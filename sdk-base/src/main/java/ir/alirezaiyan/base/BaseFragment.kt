package ir.alirezaiyan.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import com.google.android.material.snackbar.Snackbar
import ir.alirezaiyan.base.ext.Failure
import ir.alirezaiyan.base.extention.appContext
import kotlinx.android.synthetic.main.activity_layout.*

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/6/2020 11:08 AM.
 */

/**
 * Base Fragment class with helper methods for handling views and back button events.
 *
 * @see Fragment
 */

abstract class BaseFragment : Fragment() {

    abstract fun layoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        inflater.inflate(layoutId(), container, false)

    protected fun showProgress() = progressStatus(View.VISIBLE)

    protected fun hideProgress() = progressStatus(View.GONE)

    private fun progressStatus(viewStatus: Int) =
        with(activity) { if (this is BaseActivity) this.progress.visibility = viewStatus }

    protected fun notifyWithAction(@StringRes message: Int, @StringRes actionText: Int, action: () -> Any) {
        val snackBar = Snackbar.make(view!!, getString(message), Snackbar.LENGTH_INDEFINITE)
        snackBar.setAction(actionText) { action.invoke() }
        snackBar.setActionTextColor(
            ContextCompat.getColor(
                appContext,
                R.color.colorPrimary
            )
        )
        snackBar.show()
    }
}

inline fun <reified T : ViewModel> Fragment.viewModel(
    factory: ViewModelProvider.Factory,
    body: T.() -> Unit
): T {
    val vm = ViewModelProvider(this, factory).get(T::class.java)
    vm.body()
    return vm
}

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) =
    liveData.observe(this, Observer(body))

fun <L : LiveData<Failure>> LifecycleOwner.failure(liveData: L, body: (Failure?) -> Unit) =
    liveData.observe(this, Observer(body))
package ir.alirezaiyan.base.component

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import ir.alirezaiyan.base.R
import ir.alirezaiyan.base.utils.EndlessOnScrollListener
import kotlinx.android.synthetic.main.component_doctor_list.view.*

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/6/2020 12:44 PM.
 */
@SuppressLint("ViewConstructor")
class DoctorListComponent<VH : RecyclerView.ViewHolder?> private constructor(
    context: Context,
    title: String?,
    layoutManager: RecyclerView.LayoutManager,
    scrollListener: EndlessOnScrollListener,
    adapter: RecyclerView.Adapter<VH>
) : LinearLayout(context) {

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.component_doctor_list, this, true)

        orientation = VERTICAL

        prepare(title, layoutManager, scrollListener, adapter)
    }

    private fun prepare(
        title: String?,
        layoutManager: RecyclerView.LayoutManager,
        scrollListener: EndlessOnScrollListener,
        adapter: RecyclerView.Adapter<VH>
    ) {

        componentTitle.text = title
        componentList.apply {
            this.layoutManager = layoutManager
            this.adapter = adapter
            this.addOnScrollListener(scrollListener)
            this.setHasFixedSize(true)
            this.setItemViewCacheSize(20)
        }

    }

    data class Builder<VH : RecyclerView.ViewHolder>(var context: Context) {

        var title: String? = ""
        private lateinit var scrollListener: EndlessOnScrollListener
        private lateinit var layoutManager: RecyclerView.LayoutManager
        private lateinit var adapter: RecyclerView.Adapter<VH>

        fun title(title: String) = apply { this.title = title }
        fun layoutManager(layoutManager: RecyclerView.LayoutManager) =
            apply { this.layoutManager = layoutManager }

        fun scrollListener(scrollListener: EndlessOnScrollListener) =
            apply { this.scrollListener = scrollListener }

        fun adapter(adapter: RecyclerView.Adapter<VH>) = apply { this.adapter = adapter }
        fun build() = DoctorListComponent(context, title, layoutManager, scrollListener, adapter)
    }

}
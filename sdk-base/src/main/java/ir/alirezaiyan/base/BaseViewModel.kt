package ir.alirezaiyan.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.alirezaiyan.base.ext.Failure

/**
 * Base ViewModel class with default Failure handling.
 * @see ViewModel
 * @see Failure
 */
abstract class BaseViewModel : ViewModel() {

    var failure: MutableLiveData<Failure> = MutableLiveData()

    protected fun handleFailure(failure: Failure) {
        this.failure.value = failure
    }

    override fun onCleared() {
        super.onCleared()
        cancelRequest()
    }

    abstract fun cancelRequest()
}
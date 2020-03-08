package ir.alirezaiyan.arzte.ui

import androidx.lifecycle.MutableLiveData
import ir.alirezaiyan.base.BaseViewModel
import ir.alirezaiyan.data.entity.Doctor
import ir.alirezaiyan.domain.GetDoctors
import ir.alirezaiyan.domain.ext.UseCase.None
import javax.inject.Inject

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/8/2020 2:58 AM.
 */
class MainViewModel
@Inject constructor(private val getdoctors: GetDoctors) : BaseViewModel() {

    val doctors = MutableLiveData<List<Doctor>>()

    init {
        loadDoctors()
    }

    fun loadDoctors() = getdoctors(None()) { it.either(::handleFailure, ::handleDoctorList) }

    private fun handleDoctorList(doctors: List<Doctor>) {
        this.doctors.value = doctors
    }

    override fun cancelRequest() {
        getdoctors.cancel()
    }
}
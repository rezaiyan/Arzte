package ir.alirezaiyan.arzte.ui

import androidx.lifecycle.MutableLiveData
import ir.alirezaiyan.base.BaseViewModel
import ir.alirezaiyan.data.entity.Doctor
import ir.alirezaiyan.data.entity.None
import ir.alirezaiyan.domain.GetDoctors
import ir.alirezaiyan.domain.RecentDoctors
import javax.inject.Inject

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/8/2020 2:58 AM.
 */
class MainViewModel
@Inject constructor(private val getDoctors: GetDoctors, private val recentDoctors: RecentDoctors) :
    BaseViewModel() {

    val vivyDoctorsLiveData = MutableLiveData<List<Doctor>>()
    val recentDoctorsLiveData = MutableLiveData<List<Doctor>>()

    init {
        loadDoctors()
        updateRecentDoctors(null)
    }

    fun loadDoctors() = getDoctors(None()) { it.either(::handleFailure, ::handleVivyDoctorList) }

    private fun handleVivyDoctorList(doctors: List<Doctor>) {
        this.vivyDoctorsLiveData.value = doctors
    }

    private fun handleRecentDoctorList(doctors: List<Doctor>) {
        this.recentDoctorsLiveData.value = doctors
    }

    override fun cancelRequest() {
        getDoctors.cancel()
    }

    fun updateRecentDoctors(doctor: Doctor?) {
        recentDoctors(doctor) { it.either(::handleFailure, ::handleRecentDoctorList) }
    }
}
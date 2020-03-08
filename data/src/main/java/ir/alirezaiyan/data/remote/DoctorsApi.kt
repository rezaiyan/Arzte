package ir.alirezaiyan.data.remote

import ir.alirezaiyan.data.entity.DoctorResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

internal interface DoctorsApi {
    companion object {
        private const val PARAM_KEY = "paramKey"
        private const val DOCTORS = "/interviews/challenges/android/doctors{$PARAM_KEY}.json"
    }

    @GET(DOCTORS)
    fun doctors(@Path(PARAM_KEY) path: String?): Call<DoctorResponse>
}

package ir.alirezaiyan.data.remote

import ir.alirezaiyan.data.entity.DoctorResponse
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/8/2020 1:33 AM.
 */
@Singleton
class DoctorsService
@Inject constructor(retrofit: Retrofit) : DoctorsApi {
    private val moviesApi by lazy { retrofit.create(DoctorsApi::class.java) }

    override fun doctors(path: String?): Call<DoctorResponse> {
        return if (path.isNullOrBlank()) {
            moviesApi.doctors("")
        } else {
            moviesApi.doctors("-$path")
        }

    }
}

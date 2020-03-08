package ir.alirezaiyan.data.repository

import ir.alirezaiyan.base.ext.Either
import ir.alirezaiyan.base.ext.Failure
import ir.alirezaiyan.data.entity.Doctor
import ir.alirezaiyan.data.entity.DoctorResponse
import ir.alirezaiyan.data.remote.DoctorsService
import retrofit2.Call
import javax.inject.Inject

class DoctorsRepositoryImpl @Inject constructor(private val service: DoctorsService) :
    DoctorsRepository {

    private var lastKey: String? = ""

    override fun doctors(): Either<Failure, List<Doctor>> {
        return if (lastKey != null) {
            request(
                service.doctors(lastKey), { lastKey = it.lastKey; it.doctors },
                DoctorResponse("", emptyList())
            )
        } else {
            Either.Left(Failure.EndOfList)
        }
    }

    private fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure, R> {
        return try {
            val response = call.execute()
            when (response.isSuccessful) {
                true -> Either.Right(transform((response.body() ?: default)))
                false -> Either.Left(Failure.ServerError)
            }
        } catch (exception: Throwable) {
            Either.Left(Failure.ServerError)
        }
    }

}

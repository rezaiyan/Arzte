package ir.alirezaiyan.data.repository

import ir.alirezaiyan.base.ext.Either
import ir.alirezaiyan.base.ext.Failure
import ir.alirezaiyan.data.entity.Doctor

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/8/2020 1:55 AM.
 */
interface DoctorsRepository {
    fun doctors(): Either<Failure, List<Doctor>>
}
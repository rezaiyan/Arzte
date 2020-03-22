package ir.alirezaiyan.domain

import ir.alirezaiyan.base.ext.UseCase
import ir.alirezaiyan.data.entity.Doctor
import ir.alirezaiyan.data.entity.None
import ir.alirezaiyan.data.repository.DoctorsRepository
import javax.inject.Inject

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/8/2020 1:55 AM.
 */

class GetDoctors @Inject constructor(private val repository: DoctorsRepository) :
    UseCase<List<Doctor>, None>() {

    override suspend fun run(params: None) = repository.doctors()
}

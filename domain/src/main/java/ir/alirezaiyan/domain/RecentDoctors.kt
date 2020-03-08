package ir.alirezaiyan.domain

import ir.alirezaiyan.data.entity.Doctor
import ir.alirezaiyan.data.repository.DoctorsRepository
import ir.alirezaiyan.domain.ext.UseCase
import javax.inject.Inject

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/9/2020 12:41 AM.
 */
class RecentDoctors @Inject constructor(private val repository: DoctorsRepository) :
    UseCase<List<Doctor>, Doctor?>() {

    override suspend fun run(doctor: Doctor?) = repository.updateRecentDoctors(doctor)
}
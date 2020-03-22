package ir.alirezaiyan.domain

import ir.alirezaiyan.base.ext.UseCase
import ir.alirezaiyan.data.entity.Doctor
import ir.alirezaiyan.data.repository.DoctorsRepository
import javax.inject.Inject

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/9/2020 12:41 AM.
 */
class RecentDoctors @Inject constructor(private val repository: DoctorsRepository) :
    UseCase<List<Doctor>, Doctor?>() {

    override suspend fun run(params: Doctor?) = repository.updateRecentDoctors(params)
}
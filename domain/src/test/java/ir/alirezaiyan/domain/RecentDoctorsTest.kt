package ir.alirezaiyan.domain

import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import ir.alirezaiyan.base.ext.Either
import ir.alirezaiyan.data.entity.Doctor
import ir.alirezaiyan.data.repository.DoctorsRepository
import ir.alirezaiyan.test.UnitTest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/9/2020 5:10 PM.
 */
class RecentDoctorsTest : UnitTest() {

    private lateinit var recentDoctors: RecentDoctors

    @Mock
    private lateinit var repository: DoctorsRepository

    private val inputParam = Doctor()

    @Before
    fun setup() {
        recentDoctors = RecentDoctors(repository)
        given { repository.updateRecentDoctors(inputParam) }.willReturn(Either.Right(listOf()))
    }

    @Test
    fun getDataFromRepositoryTest() {
        runBlocking { recentDoctors.run(inputParam) }

        verify(repository).updateRecentDoctors(inputParam)
        verifyNoMoreInteractions(repository)
    }

}
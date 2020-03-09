package ir.alirezaiyan.domain

import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import ir.alirezaiyan.base.ext.Either
import ir.alirezaiyan.data.entity.None
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
class GetDoctorsTest : UnitTest() {

    private lateinit var getDoctors: GetDoctors

    @Mock
    private lateinit var repository: DoctorsRepository

    @Before
    fun setup() {
        getDoctors = GetDoctors(repository)
        given { repository.doctors() }.willReturn(Either.Right(listOf()))
    }

    @Test
    fun getDataFromRepositoryTest() {
        runBlocking { getDoctors.run(None()) }

        verify(repository).doctors()
        verifyNoMoreInteractions(repository)
    }

}
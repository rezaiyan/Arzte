package ir.alirezaiyan.data.repository

import ir.alirezaiyan.data.entity.Doctor
import ir.alirezaiyan.test.UnitTest
import org.junit.Test

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/10/2020 12:35 AM.
 */
class DoctorsRepositoryImplTest : UnitTest() {


    private val lastKey = ""
    private val mockResponse = listOf(Doctor())

    @Test
    fun serverErrorTest() {
        DoctorRepositoryBot()
            .responseBeSuccessful(false)
            .warmUp()
            .run(mockResponse)
            .verifyDoctors(lastKey)
    }

    @Test
    fun successfulResultTest() {
        DoctorRepositoryBot()
            .responseBeSuccessful(true)
            .doctorsReturnsThisCall(lastKey)
            .responseBodyReturns(mockResponse)
            .warmUp()
            .run(mockResponse)
            .verifyDoctors(lastKey)
    }

}
package ir.alirezaiyan.data.local

import android.content.SharedPreferences
import ir.alirezaiyan.data.entity.Doctor
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/9/2020 2:47 AM.
 */

@RunWith(
    MockitoJUnitRunner::class
)
class CacheTest {

    private lateinit var sharedPrefs: SharedPreferences
    @Mock
    val cache: Cache? = null

    @Before
    fun setup() {
        this.sharedPrefs = Mockito.mock(SharedPreferences::class.java)
        cache!!.cache = (sharedPrefs as SharedPreferences?)!!
    }

    @Test
    fun getRecentListTest() {
        val list = cache!!.getRecentDoctors()
        assert(list.isEmpty())
        val doctor = Doctor()
        doctor.id = "abcd"
        doctor.name = "Test"
        val resultList = mutableListOf(doctor)

//        doReturn(resultList).doAnswer { cache.updateRecentDoctors(doctor) }.`when`(cache.getRecentDoctors())
    }

}
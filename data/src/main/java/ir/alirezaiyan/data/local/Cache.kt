package ir.alirezaiyan.data.local

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ir.alirezaiyan.data.entity.Doctor
import javax.inject.Inject

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/9/2020 12:36 AM.
 */

class Cache @Inject constructor() {

    @Inject
    lateinit var cache: SharedPreferences
    private val RECENT_DOCTORS_KEY = "recentDoctors"

    fun updateRecentDoctors(doctor: Doctor?) {
        val doctorJsonList = getRecentDoctors()

        doctor?.let {
            if (!doctorJsonList.contains(doctor)) {
                if (doctorJsonList.size > 2) {
                    doctorJsonList.removeAt(0)
                }
                doctorJsonList.add(doctor)
            } else {
                doctorJsonList.remove(doctor)
                doctorJsonList.add(doctor)
            }
        }

        val recentDoctors = Gson().toJson(doctorJsonList)
        cache.edit()?.putString(RECENT_DOCTORS_KEY, recentDoctors)?.apply()
    }

    fun getRecentDoctors(): ArrayList<Doctor> {
        val recentCachedDoctors = cache.getString(RECENT_DOCTORS_KEY, "")
        if (recentCachedDoctors!!.isEmpty())
            return arrayListOf()

        return Gson().fromJson<ArrayList<Doctor>>(
            recentCachedDoctors,
            object : TypeToken<ArrayList<Doctor>>() {}.type
        )
    }
}
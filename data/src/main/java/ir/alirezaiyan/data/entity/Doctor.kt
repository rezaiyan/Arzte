package ir.alirezaiyan.data.entity

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/5/2020 1:51 PM.
 */

data class DoctorResponse(var lastKey: String?, var doctors: List<Doctor>)

fun DoctorResponse.empty() = DoctorResponse("", emptyList())

data class Doctor(
    var id: String? = null,
    var name: String? = null,
    var photoId: String? = null,
    var rating: Double? = null,
    var address: String? = null,
    var lat: Double? = null,
    var lng: Double? = null,
    var highlighted: Boolean? = null,
    var reviewCount: Int? = null,
    var specialityIds: List<Int>? = null,
    var source: String? = null,
    var phoneNumber: String? = null,
    var email: String? = null,
    var website: String? = null,
    var openingHours: List<String>? = null,
    var integration: Any? = null,
    var translation: Any? = null
)
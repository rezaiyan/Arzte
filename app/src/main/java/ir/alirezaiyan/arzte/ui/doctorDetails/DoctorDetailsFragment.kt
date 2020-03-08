package ir.alirezaiyan.arzte.ui.doctorDetails

import android.os.Bundle
import android.view.View
import ir.alirezaiyan.arzte.R
import ir.alirezaiyan.base.BaseFragment
import ir.alirezaiyan.base.extention.loadFromUrl
import ir.alirezaiyan.data.entity.Doctor
import ir.alirezaiyan.data.entity.toDoctor
import kotlinx.android.synthetic.main.fragment_doctor_details.*

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/8/2020 6:55 PM.
 */
class DoctorDetailsFragment : BaseFragment() {

    override fun layoutId() = R.layout.fragment_doctor_details

    companion object {
        private const val INTENT_EXTRA_PARAM_DOCTOR = "ir.alirezaiyan.arzte.ui.doctorDetails.doctor"

        fun showDoctor(doctor: String) = DoctorDetailsFragment().apply {
            val bundle = Bundle()
            bundle.putString(INTENT_EXTRA_PARAM_DOCTOR, doctor)
            arguments = bundle
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val doctor: Doctor = (arguments!!.getString(INTENT_EXTRA_PARAM_DOCTOR))!!.toDoctor()
        ratingBar.rating = doctor.rating?.toFloat()!!
        name.text = doctor.name
        address.text = doctor.address
        phone.text = doctor.phoneNumber
        website.text = doctor.website
        avatar.loadFromUrl(doctor.photoId)

    }

}
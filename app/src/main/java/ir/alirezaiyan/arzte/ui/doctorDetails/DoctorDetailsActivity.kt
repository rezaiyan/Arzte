package ir.alirezaiyan.arzte.ui.doctorDetails

import android.content.Context
import android.content.Intent
import ir.alirezaiyan.base.BaseActivity
import ir.alirezaiyan.data.entity.Doctor

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/8/2020 6:53 PM.
 */
class DoctorDetailsActivity : BaseActivity() {

    companion object {
        private const val INTENT_EXTRA_PARAM_DOCTOR = "ir.alirezaiyan.arzte.ui.doctorDetails.doctor"

        fun callingIntent(context: Context, doctor: Doctor): Intent {
            val intent = Intent(context, DoctorDetailsActivity::class.java)
            intent.putExtra(INTENT_EXTRA_PARAM_DOCTOR, doctor.toString())
            return intent
        }
    }

    override fun fragment() =
        DoctorDetailsFragment.showDoctor(intent.getStringExtra(INTENT_EXTRA_PARAM_DOCTOR)!!)
}
package ir.alirezaiyan.arzte.ui

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import ir.alirezaiyan.arzte.R
import ir.alirezaiyan.base.BaseFragment
import ir.alirezaiyan.base.component.DoctorListComponent

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/6/2020 11:29 AM.
 */
class MainFragment : BaseFragment() {

    override fun layoutId() = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainContainer = view.findViewById<FrameLayout>(R.id.mainContainer)

        val doctorListComponent = DoctorListComponent
            .Builder<DoctorsViewHolder>(requireContext())
            .title(getString(R.string.doctors_list))
            .adapter(ViviDoctorsAdapter(listOf()))
            .layoutManager(LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false))
            .build()

        mainContainer.addView(doctorListComponent)


    }
}
package ir.alirezaiyan.arzte.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.annotation.StringRes
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ir.alirezaiyan.arzte.Arzte
import ir.alirezaiyan.arzte.R
import ir.alirezaiyan.arzte.core.di.ApplicationComponent
import ir.alirezaiyan.arzte.ui.doctorDetails.DoctorDetailsActivity
import ir.alirezaiyan.arzte.ui.recentDoctors.RecentDoctorsAdapter
import ir.alirezaiyan.arzte.ui.vivyDoctors.VivyDoctorsAdapter
import ir.alirezaiyan.base.BaseFragment
import ir.alirezaiyan.base.component.DoctorListComponent
import ir.alirezaiyan.base.ext.Failure
import ir.alirezaiyan.base.extention.gone
import ir.alirezaiyan.base.extention.invisible
import ir.alirezaiyan.base.extention.visible
import ir.alirezaiyan.base.failure
import ir.alirezaiyan.base.observe
import ir.alirezaiyan.base.utils.EndlessOnScrollListener
import ir.alirezaiyan.base.viewModel
import ir.alirezaiyan.data.entity.Doctor
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/6/2020 11:29 AM.
 */
class MainFragment : BaseFragment() {

    override fun layoutId() = R.layout.fragment_main

    private val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (activity?.application as Arzte).appComponent
    }
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var vivyDoctorsAdapter: VivyDoctorsAdapter
    @Inject
    lateinit var recentDoctorsAdapter: RecentDoctorsAdapter

    private lateinit var mainViewModel: MainViewModel

    private val endlessScroll = object : EndlessOnScrollListener() {
        override fun onLoadMore() {
            loadDoctorsList()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appComponent.inject(this)

        showProgress()
        mainViewModel = viewModel(viewModelFactory) {
            observe(vivyDoctorsLiveData, ::renderVivyList)
            observe(recentDoctorsLiveData, ::renderRecentList)
            failure(failure, ::handleFailure)
        }

        val recentDoctorListComponent = DoctorListComponent
            .Builder<RecentDoctorsAdapter.ViewHolder>(requireContext())
            .title(getString(R.string.recent_doctors_list))
            .adapter(recentDoctorsAdapter)
            .scrollListener(endlessScroll)
            .layoutManager(LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false))
            .build()

        fragmentHeaderContainer.addView(recentDoctorListComponent)
        fragmentHeaderContainer.gone()

        val doctorListComponent = DoctorListComponent
            .Builder<VivyDoctorsAdapter.ViewHolder>(requireContext())
            .title(getString(R.string.vivy_doctors_list))
            .adapter(vivyDoctorsAdapter)
            .scrollListener(endlessScroll)
            .layoutManager(LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false))
            .build()

        mainContainer.addView(doctorListComponent)


        val onVivyDoctorClickListener: (Doctor, View) -> Unit = { doctor, navigationExtras ->
            mainViewModel.updateRecentDoctors(doctor)
            showDoctorDetails(activity!!, doctor, navigationExtras)
        }

        val onRecentDoctorClickListener: (Doctor, View) -> Unit = { doctor, navigationExtras ->
            showDoctorDetails(activity!!, doctor, navigationExtras)
        }
        vivyDoctorsAdapter.clickListener = onVivyDoctorClickListener
        recentDoctorsAdapter.clickListener = onRecentDoctorClickListener

    }

    private fun loadDoctorsList() {
        emptyView.invisible()
        mainContainer.visible()
        showProgress()
        mainViewModel.loadDoctors()
    }

    private fun renderVivyList(doctors: List<Doctor>?) {
        doctors?.sortedBy { it.rating!!.toFloat() }
        vivyDoctorsAdapter.collection += doctors.orEmpty()

        hideProgress()
    }

    private fun renderRecentList(doctors: List<Doctor>?) {
        recentDoctorsAdapter.collection = doctors.orEmpty()
        if (recentDoctorsAdapter.itemCount > 0) {
            fragmentHeaderContainer.visible()
        } else {
            fragmentHeaderContainer.gone()
        }
    }

    private fun handleFailure(failure: Failure?) {
        when (failure) {
            is Failure.NetworkConnection -> renderFailure(R.string.failure_network_connection)
            is Failure.ServerError -> renderFailure(R.string.failure_server_error)
            is Failure.EndOfList -> {
                endlessScroll.onReachEnd()
                hideProgress()
            }
        }
    }

    private fun renderFailure(@StringRes message: Int) {
        endlessScroll.onFailure()
        mainContainer.invisible()
        emptyView.visible()
        hideProgress()
        notifyWithAction(message, R.string.action_refresh, ::loadDoctorsList)
    }

    private fun showDoctorDetails(activity: FragmentActivity, doctor: Doctor, view: View) {
        val intent = DoctorDetailsActivity.callingIntent(activity, doctor)
        val sharedView = view as ImageView
        val activityOptions = ActivityOptionsCompat
            .makeSceneTransitionAnimation(activity, sharedView, sharedView.transitionName)
        activity.startActivity(intent, activityOptions.toBundle())
    }
}
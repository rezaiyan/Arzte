package ir.alirezaiyan.arzte.ui.recentDoctors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.alirezaiyan.arzte.R
import ir.alirezaiyan.base.extention.loadCircular
import ir.alirezaiyan.data.entity.Doctor
import kotlinx.android.synthetic.main.item_doctor_h.view.*
import kotlinx.android.synthetic.main.item_doctor_v.view.avatar
import kotlinx.android.synthetic.main.item_doctor_v.view.name
import javax.inject.Inject
import kotlin.properties.Delegates

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/9/2020 12:09 AM.
 */
class RecentDoctorsAdapter
@Inject constructor() : RecyclerView.Adapter<RecentDoctorsAdapter.ViewHolder>() {

    internal var collection: List<Doctor> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }
    internal var clickListener: (Doctor, View) -> Unit = { _, _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_doctor_h,
                parent,
                false
            )
        )

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) =
        viewHolder.bind(collection[position], clickListener)

    override fun getItemCount() = collection.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(doctor: Doctor, clickListener: (Doctor, View) -> Unit) {
            itemView.name.text = doctor.name
            itemView.avatar.loadCircular(doctor.photoId)
            itemView.rate.text = doctor.rating?.toInt()!!.toString()
            itemView.setOnClickListener { clickListener(doctor, itemView.avatar) }
        }
    }
}
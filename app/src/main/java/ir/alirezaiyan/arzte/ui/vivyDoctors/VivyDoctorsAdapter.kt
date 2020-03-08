package ir.alirezaiyan.arzte.ui.vivyDoctors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.alirezaiyan.arzte.R
import ir.alirezaiyan.base.extention.loadFromUrl
import ir.alirezaiyan.data.entity.Doctor
import kotlinx.android.synthetic.main.item_doctor_v.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/8/2020 11:49 AM.
 */
class VivyDoctorsAdapter
@Inject constructor() : RecyclerView.Adapter<VivyDoctorsAdapter.ViewHolder>() {

    internal var collection: List<Doctor> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }
    internal var clickListener: (Doctor, View) -> Unit = { _, _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_doctor_v,
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
            itemView.description.text = doctor.address
            itemView.avatar.loadFromUrl(doctor.photoId)
            itemView.rateBar.rating = doctor.rating?.toFloat()!!
            itemView.setOnClickListener { clickListener(doctor, itemView.avatar) }
        }
    }
}
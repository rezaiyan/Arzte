package ir.alirezaiyan.arzte.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.alirezaiyan.arzte.R
import ir.alirezaiyan.base.Doctor

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/6/2020 7:42 PM.
 */
class ViviDoctorsAdapter(private val list: List<Doctor>) :
    RecyclerView.Adapter<DoctorsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DoctorsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_doctor,
                parent,
                false
            )
        )

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: DoctorsViewHolder, position: Int) {
        holder.bind(list[position])
    }

}
package ir.alirezaiyan.arzte.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.alirezaiyan.arzte.R
import ir.alirezaiyan.base.Doctor

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/6/2020 7:42 PM.
 */
class DoctorsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val name: TextView = view.findViewById(R.id.itemTitle)

    fun bind(doctor: Doctor) {
        name.text = doctor.name
    }

}
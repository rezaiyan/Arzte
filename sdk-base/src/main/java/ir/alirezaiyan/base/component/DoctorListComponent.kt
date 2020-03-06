package ir.alirezaiyan.base.component

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.alirezaiyan.base.R

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/6/2020 12:44 PM.
 */
@SuppressLint("ViewConstructor")
class DoctorListComponent<VH : RecyclerView.ViewHolder?> private constructor(
    context: Context,
    title: String?,
    layoutManager: RecyclerView.LayoutManager?,
    adapter: RecyclerView.Adapter<VH>?
) : LinearLayout(context) {

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.component_doctor_list, this, true)

        orientation = VERTICAL

        prepare(title, layoutManager, adapter)
    }

    private fun prepare(
        title: String?,
        layoutManager: RecyclerView.LayoutManager?,
        adapter: RecyclerView.Adapter<VH>?
    ) {

        findViewById<TextView>(R.id.component_doctorlist_title).text = title
        val recyclerView = findViewById<RecyclerView>(R.id.component_doctorlist_recyclerview)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

    }

    data class Builder<VH : RecyclerView.ViewHolder>(
        var context: Context,
        var title: String? = "",
        var layoutManager: RecyclerView.LayoutManager? = null,
        var adapter: RecyclerView.Adapter<VH>? = null
    ) {

        fun title(title: String) = apply { this.title = title }
        fun layoutManager(layoutManager: RecyclerView.LayoutManager) =
            apply { this.layoutManager = layoutManager }

        fun adapter(adapter: RecyclerView.Adapter<VH>) = apply { this.adapter = adapter }
        fun build() = DoctorListComponent(context, title, layoutManager, adapter)
    }

}
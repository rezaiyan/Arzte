package ir.alirezaiyan.base.extention

import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso
import ir.alirezaiyan.base.R
import ir.alirezaiyan.base.utils.CircleTransform

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/8/2020 11:56 AM.
 */

fun ImageView.loadFromUrl(url: String?) {
    Picasso.get().load(url)
        .placeholder(R.drawable.placeholder)
        .error(R.drawable.placeholder).into(this)
}


fun ImageView.loadCircular(url: String?) {
    Picasso.get().load(url)
        .placeholder(R.drawable.placeholder)
        .error(R.drawable.placeholder)
        .transform(CircleTransform())
        .into(this)
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}
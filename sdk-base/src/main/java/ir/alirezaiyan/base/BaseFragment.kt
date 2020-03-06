package ir.alirezaiyan.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/6/2020 11:08 AM.
 */

/**
 * Base Fragment class with helper methods for handling views and back button events.
 *
 * @see Fragment
 */

abstract class BaseFragment : Fragment() {

    abstract fun layoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        inflater.inflate(layoutId(), container, false)
}
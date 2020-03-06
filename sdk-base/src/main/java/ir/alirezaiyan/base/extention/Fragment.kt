package ir.alirezaiyan.base.extention

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/6/2020 11:12 AM.
 */

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) =
    beginTransaction().func().commit()
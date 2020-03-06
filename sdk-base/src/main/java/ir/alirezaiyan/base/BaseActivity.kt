package ir.alirezaiyan.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.alirezaiyan.base.extention.inTransaction
import kotlinx.android.synthetic.main.activity_layout.*

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/6/2020 11:05 AM.
 */

/**
 * Base Activity class with helper methods for handling fragment transactions and back button
 * events.
 *
 * @see AppCompatActivity
 */

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)
        setSupportActionBar(toolbar)
        addFragment(savedInstanceState)
    }

    private fun addFragment(savedInstanceState: Bundle?) =
        savedInstanceState ?: supportFragmentManager.inTransaction {
            add(R.id.fragmentContainer, fragment())
        }

    abstract fun fragment(): BaseFragment
}
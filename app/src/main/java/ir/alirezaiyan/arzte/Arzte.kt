package ir.alirezaiyan.arzte

import android.app.Application
import ir.alirezaiyan.arzte.core.di.ApplicationComponent
import ir.alirezaiyan.arzte.core.di.ApplicationModule
import ir.alirezaiyan.arzte.core.di.DaggerApplicationComponent

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/6/2020 2:25 AM.
 */
class Arzte : Application() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        this.injectMembers()
    }


    private fun injectMembers() = appComponent.inject(this)
}
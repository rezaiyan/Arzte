package ir.alirezaiyan.arzte.core.di

import dagger.Component
import ir.alirezaiyan.arzte.Arzte
import ir.alirezaiyan.arzte.ui.MainFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(application: Arzte)
    fun inject(mainFragment: MainFragment)
}

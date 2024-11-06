package solutions.s4y.puredemo.dagger

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import solutions.s4y.puredemo.MainActivity
import solutions.s4y.puredemo.dagger.annotations.ApplicationScope
import solutions.s4y.puredemo.dagger.modules.AssetDaoDbModule
import solutions.s4y.puredemo.dagger.modules.DriversModule
import solutions.s4y.puredemo.dagger.modules.ViewModelsModule

@ApplicationScope
@Component(modules = [ViewModelsModule::class, AssetDaoDbModule::class, DriversModule::class])
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }

    fun inject(activity: MainActivity)
}
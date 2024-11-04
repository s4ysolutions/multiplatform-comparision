package solutions.s4y.puredemo.dagger

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import solutions.s4y.puredemo.MainActivity
import solutions.s4y.puredemo.dagger.annotations.ApplicationScope
import solutions.s4y.puredemo.dagger.modules.ViewModelModule

@ApplicationScope
@Component(modules = [ViewModelModule::class])
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }

    fun inject(activity: MainActivity)
}
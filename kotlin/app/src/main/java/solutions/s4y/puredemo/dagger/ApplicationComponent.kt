package solutions.s4y.puredemo.dagger

import android.content.Context
import dagger.Component
import dagger.BindsInstance
import solutions.s4y.puredemo.TheApplication
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }

    fun inject(theApplication: TheApplication)
}
package solutions.s4y.puredemo

import android.app.Application
import solutions.s4y.puredemo.dagger.ApplicationComponent
import solutions.s4y.puredemo.dagger.DaggerApplicationComponent
import javax.inject.Inject

class TheApplication: Application() {
    private lateinit var _appComponent: ApplicationComponent
    val appComponent get() = _appComponent
    @Inject
    lateinit var consumer: Consumer

    override fun onCreate() {
        super.onCreate()
        _appComponent = DaggerApplicationComponent.factory().create(applicationContext)
        appComponent.inject(this)
        consumer.consume()
    }
}
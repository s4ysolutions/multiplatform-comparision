package solutions.s4y.puredemo

import android.app.Application
import solutions.s4y.puredemo.dagger.ApplicationComponent
import solutions.s4y.puredemo.dagger.DaggerApplicationComponent

open class TheApplication: Application() {
    private lateinit var _appComponent: ApplicationComponent
    val dagger get() = _appComponent

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    protected fun initDagger() {
        _appComponent = DaggerApplicationComponent.factory().create(this)
    }

    companion object {
        private val TAG = "WarriorApplication"
    }
}
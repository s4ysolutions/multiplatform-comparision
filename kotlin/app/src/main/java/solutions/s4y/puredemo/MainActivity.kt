package solutions.s4y.puredemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.lifecycle.ViewModelProvider
import solutions.s4y.puredemo.ui.compose.Main
import solutions.s4y.puredemo.ui.viewmodels.LocalDaggerViewModelFactory
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val daggerComponent = (applicationContext as TheApplication).dagger
        daggerComponent.inject(this)

        enableEdgeToEdge()
        setContent {
            CompositionLocalProvider(LocalDaggerViewModelFactory provides viewModelFactory) {
                Main()
            }
        }
    }

}
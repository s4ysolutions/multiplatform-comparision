package solutions.s4y.puredemo.ui.compose.locals

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel

val LocalViewModelFactoryProvider = staticCompositionLocalOf<ViewModelProvider.Factory> { error("No ViewModelFactory provided") }

@Composable
inline fun <reified T: ViewModel>daggerViewModel(): T {
    val viewModelFactory = LocalViewModelFactoryProvider.current
    return viewModel<T>(factory = viewModelFactory)
}
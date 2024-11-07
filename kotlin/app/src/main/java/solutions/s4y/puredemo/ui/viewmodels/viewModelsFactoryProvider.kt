package solutions.s4y.puredemo.ui.viewmodels

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel

val LocalDaggerViewModelFactory = staticCompositionLocalOf<ViewModelProvider.Factory> { error("No ViewModelFactory provided") }

@Composable
inline fun <reified T: ViewModel>daggerViewModel(): T {
    val viewModelFactory = LocalDaggerViewModelFactory.current
    return viewModel<T>(factory = viewModelFactory)
}
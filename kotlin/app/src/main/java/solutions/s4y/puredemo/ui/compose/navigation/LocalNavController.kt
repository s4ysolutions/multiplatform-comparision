package solutions.s4y.puredemo.ui.compose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavController

val LocalNavController = staticCompositionLocalOf<NavController> { error("No NavController provided") }

@Composable
fun localNavController() = LocalNavController.current
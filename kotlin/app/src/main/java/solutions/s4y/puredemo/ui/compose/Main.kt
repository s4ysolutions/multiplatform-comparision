package solutions.s4y.puredemo.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.navigation.compose.rememberNavController
import solutions.s4y.puredemo.ui.compose.bottomsheets.BottomSheetsHost
import solutions.s4y.puredemo.ui.compose.navigation.LocalNavController
import solutions.s4y.puredemo.ui.compose.scaffold.MainScaffold
import solutions.s4y.puredemo.ui.theme.PuredemoTheme

@Composable
fun Main() {
    val navController = rememberNavController()
    /*
navController.addOnDestinationChangedListener { _, destination, _ ->
    val currentDestination = navController.currentBackStackEntry?.destination?.route
    val previousDestination = navController.previousBackStackEntry?.destination?.route
}
 */
    PuredemoTheme {
        CompositionLocalProvider(LocalNavController provides navController) {
            BottomSheetsHost {
                MainScaffold(navController)
            }
        }
    }
}

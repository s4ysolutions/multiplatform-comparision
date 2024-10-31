package solutions.s4y.puredemo.ui.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import solutions.s4y.puredemo.ui.compose.scaffold.MainScaffold
import solutions.s4y.puredemo.ui.theme.PuredemoTheme

@Composable
fun Main() {
    val navController = rememberNavController()
    PuredemoTheme {
        MainScaffold(navController, modifier = Modifier.fillMaxSize())
    }
}

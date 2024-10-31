package solutions.s4y.puredemo.ui.compose.scaffold

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import solutions.s4y.puredemo.ui.compose.navigation.MainNavHost

@Composable
fun MainScaffold(navController: NavHostController, modifier: Modifier) {
    Scaffold(modifier = modifier) { innerPadding ->
        MainNavHost(navController, modifier = Modifier.padding(innerPadding))
    }
}
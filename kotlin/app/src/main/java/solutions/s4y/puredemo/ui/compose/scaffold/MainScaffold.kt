package solutions.s4y.puredemo.ui.compose.scaffold

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import solutions.s4y.puredemo.ui.compose.appbars.MainBottomBar
import solutions.s4y.puredemo.ui.compose.navigation.MainNavHost

@Composable
fun MainScaffold(navController: NavHostController) {
    Scaffold(modifier = Modifier.fillMaxSize().padding(WindowInsets.safeDrawing.asPaddingValues()),
        bottomBar = { MainBottomBar(navController) }
        ) { innerPadding ->
        MainNavHost(
            navController,
            modifier =
            Modifier.padding(innerPadding)
        )
    }
}
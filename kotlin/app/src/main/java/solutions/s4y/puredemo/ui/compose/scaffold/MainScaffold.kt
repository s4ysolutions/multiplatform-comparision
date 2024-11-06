package solutions.s4y.puredemo.ui.compose.scaffold

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import solutions.s4y.puredemo.ui.compose.appbars.ChatsAppBar
import solutions.s4y.puredemo.ui.compose.appbars.MainBottomBar
import solutions.s4y.puredemo.ui.compose.bottomsheets.BottomSheetsHost
import solutions.s4y.puredemo.ui.compose.navigation.MainNavHost
import solutions.s4y.puredemo.ui.compose.navigation.isChat
import solutions.s4y.puredemo.ui.compose.navigation.isChats
import solutions.s4y.puredemo.ui.compose.navigation.isFavorites
import solutions.s4y.puredemo.ui.compose.navigation.isHome
import solutions.s4y.puredemo.ui.compose.navigation.isSettings

// *modifier = Modifier .fillMaxSize() .padding(WindowInsets.safeDrawing.asPaddingValues()),
@Composable
fun MainScaffold(navController: NavHostController) {
    val backStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        topBar = {
            if (backStackEntry?.isChat == true) ChatsAppBar(navController)
        },
        bottomBar = { if (backStackEntry?.needsBottomBar == true) MainBottomBar(navController) }
    ) { innerPadding ->
        BottomSheetsHost {
            MainNavHost(
                navController,
                modifier =
                Modifier.padding(innerPadding)
            )
        }
    }
}

private val NavBackStackEntry.needsBottomBar: Boolean
    get() = isHome || isChats || isFavorites || isSettings
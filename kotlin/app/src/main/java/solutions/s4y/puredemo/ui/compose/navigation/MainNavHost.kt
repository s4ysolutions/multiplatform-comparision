package solutions.s4y.puredemo.ui.compose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import solutions.s4y.puredemo.ui.compose.navigation.Routes.RoutesHome
import solutions.s4y.puredemo.ui.compose.screens.HomeScreen

@Composable
fun MainNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController=navController, startDestination = RoutesHome.toString()) {
        composable(RoutesHome.toString()) { HomeScreen() }
        // composable("chats") { ChatsScreen() }
        // composable("favorites") { FavoritesScreen() }
        // composable("settings") { SettingsScreen() }
    }
}
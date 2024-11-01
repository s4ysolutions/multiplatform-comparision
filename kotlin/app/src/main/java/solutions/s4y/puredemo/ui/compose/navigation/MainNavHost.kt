package solutions.s4y.puredemo.ui.compose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import solutions.s4y.puredemo.ui.compose.navigation.Routes.RoutesChats
import solutions.s4y.puredemo.ui.compose.navigation.Routes.RoutesFavorites
import solutions.s4y.puredemo.ui.compose.navigation.Routes.RoutesHome
import solutions.s4y.puredemo.ui.compose.screens.ChatsScreen
import solutions.s4y.puredemo.ui.compose.screens.FavoritesScreen
import solutions.s4y.puredemo.ui.compose.screens.HomeScreen
import solutions.s4y.puredemo.ui.compose.screens.SettingsScreen

@Composable
fun MainNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController=navController, startDestination = RoutesHome) {
        composable<RoutesHome> { HomeScreen() }
        composable<RoutesChats> { ChatsScreen() }
        composable<RoutesFavorites> { FavoritesScreen() }
        composable<Routes.RoutesSettings> { SettingsScreen() }
    }
}
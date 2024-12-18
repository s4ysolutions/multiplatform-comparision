package solutions.s4y.puredemo.ui.compose.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import solutions.s4y.puredemo.ui.compose.screens.ChatScreen
import solutions.s4y.puredemo.ui.compose.screens.ChatsScreen
import solutions.s4y.puredemo.ui.compose.screens.FavoritesScreen
import solutions.s4y.puredemo.ui.compose.screens.HomeScreen
import solutions.s4y.puredemo.ui.compose.screens.SettingsScreen

@Composable
fun MainNavHost(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(navController = navController, startDestination = Routes.Chatting) {
        composable<Routes.Home> { it ->
            HomeScreen()
        }
        navigation<Routes.Chatting>(startDestination = Routes.Chats) {
            composable<Routes.Chats> {
                ChatsScreen(innerPadding = innerPadding) { chatId ->
                    navController.navigate(
                        Routes.Chat(
                            chatId
                        )
                    )
                }
            }
            composable<Routes.Chat> {
                ChatScreen(id = it.toRoute<Routes.Chat>().chatId, innerPadding = innerPadding) {
                    navController.popBackStack()
                }
            }
        }
        composable<Routes.Favorites> { FavoritesScreen() }
        composable<Routes.Settings> { SettingsScreen() }
    }
}
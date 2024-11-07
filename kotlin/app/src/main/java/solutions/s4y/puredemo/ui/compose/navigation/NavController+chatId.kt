package solutions.s4y.puredemo.ui.compose.navigation

import androidx.navigation.NavController

val NavController.chatId: String?
    get() = currentBackStackEntry?.arguments?.getString("chatId")
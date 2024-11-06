package solutions.s4y.puredemo.ui.compose.navigation

import androidx.navigation.NavBackStackEntry

val NavBackStackEntry.isHome: Boolean
    get() =
        this.destination.route == Routes.Home::class.qualifiedName

val NavBackStackEntry.isChats: Boolean
    get() =
        this.destination.route == Routes.Chat::class.qualifiedName ||
                this.destination.route == Routes.Chats::class.qualifiedName

val NavBackStackEntry.isFavorites: Boolean
    get() =
        this.destination.route == Routes.Favorites::class.qualifiedName

val NavBackStackEntry.isSettings: Boolean
    get() =
        this.destination.route == Routes.Settings::class.qualifiedName

val NavBackStackEntry.isChat: Boolean
    get() =
        this.destination.route == Routes.Chat::class.qualifiedName+"/{chatId}"

package solutions.s4y.puredemo.ui.compose.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes() {
    @Serializable
    data object Home : Routes()
    @Serializable
    data object Chatting : Routes()
    @Serializable
    data object Chats : Routes()
    @Serializable
    data class Chat(val chatId: String): Routes()
    @Serializable
    object Favorites : Routes()
    @Serializable
    object Settings : Routes()
}
/*
@Serializable
sealed class Routes(val path: String) {
    @Serializable
    data object Home : Routes("home")
    @Serializable
    data object Chats : Routes("chats")
    @Serializable
    data class Chat(val chatId: String) : Routes("chat/$chatId") {
        companion object {
            val path = "chat/{chatId}"
        }
    }
    @Serializable
    object Favorites : Routes("favorites")
    @Serializable
    object Settings : Routes("settings")
}
*/
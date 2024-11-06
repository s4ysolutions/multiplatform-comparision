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
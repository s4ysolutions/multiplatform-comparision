package solutions.s4y.puredemo.ui.compose.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import solutions.s4y.puredemo.ui.compose.composables.ChatsPanel
import solutions.s4y.puredemo.ui.compose.composables.chats.ChatsList

@Composable
fun ChatsScreen(modifier: Modifier = Modifier, onSelectChat: (String) -> Unit) {
    ChatsPanel {
        ChatsList(onItemClick = onSelectChat)
    }
}

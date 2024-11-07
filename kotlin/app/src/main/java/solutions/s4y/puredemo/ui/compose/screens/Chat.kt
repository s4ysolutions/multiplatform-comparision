package solutions.s4y.puredemo.ui.compose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import solutions.s4y.puredemo.ui.compose.composables.ChatsPanel
import solutions.s4y.puredemo.ui.compose.composables.chat.ChatHistory
import solutions.s4y.puredemo.ui.compose.composables.chat.ChatInput
import solutions.s4y.puredemo.ui.compose.composables.chat.CommonTemptations

@Composable
fun ChatScreen(id: String, innerPadding: PaddingValues, onBack: () -> Unit) {
    Box(modifier = Modifier.padding(innerPadding)) {
        CommonTemptations(modifier = Modifier.align(Alignment.TopCenter))

        ChatsPanel(paddingValues = innerPadding) {
            Column {
                Box(modifier = Modifier.weight(1f)) {
                    ChatHistory()
                }
                ChatInput()
            }
        }
    }
}

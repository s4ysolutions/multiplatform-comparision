package solutions.s4y.puredemo.ui.compose.composables.chats

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import solutions.s4y.puredemo.ca.domain.models.ChatInfo
import solutions.s4y.puredemo.ui.theme.BodyMedium

@Composable
fun ChatInfoListItem(chat: ChatInfo, onClick: () -> Unit) {
    Row(modifier = Modifier.clickable { onClick() }) {
        Text(text ="ChatInfoListItem(${chat.imageUrl})", color = BodyMedium)
    }
}
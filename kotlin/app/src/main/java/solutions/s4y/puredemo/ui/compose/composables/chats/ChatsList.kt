package solutions.s4y.puredemo.ui.compose.composables.chats

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import solutions.s4y.puredemo.ca.domain.models.ChatInfo

@Composable
fun ChatsList(
    chats: List<ChatInfo>,
    onItemClick: (String) -> Unit
) {
    LazyColumn {
        items(chats.size) { index ->
            val chatInfo = chats[index]
            ChatInfoListItem(chatInfo, onClick = {
                onItemClick(chatInfo.imageUrl)
            })
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
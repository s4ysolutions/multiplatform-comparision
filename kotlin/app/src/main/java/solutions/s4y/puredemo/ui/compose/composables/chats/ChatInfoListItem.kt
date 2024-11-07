package solutions.s4y.puredemo.ui.compose.composables.chats

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import solutions.s4y.puredemo.ca.domain.models.ChatInfo
import solutions.s4y.puredemo.extension.resourceId
import solutions.s4y.puredemo.ui.compose.composables.images.CircleAvatar

@Composable
fun ChatInfoListItem(chat: ChatInfo, onClick: () -> Unit) {
    val painter = painterResource(id = chat.resourceId)

    Row(
        modifier = Modifier.clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircleAvatar(
            painter = painterResource(id = chat.resourceId),
            contentDescription = chat.imageUrl,
            modifier = Modifier
                .size(60.dp)
                .then(
                    if (chat.hasUnreadMessage)
                        Modifier.border(3.dp, Color.White, CircleShape)
                    else
                        Modifier
                ),
            //contentScale = ContentScale.Inside
            /*
            contentScale = if (imageSize.width > imageSize.height) {
                ContentScale.FillHeight // If width > height, fill height and crop width
            } else {
                ContentScale.FillWidth // If height > width, fill width and crop height
            }
             */
        )
        Text(
            text = chat.lastMessage,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f).padding(start = 16.dp, end = 16.dp),
        )
        if (chat.hasUnreadMessage) {
            RowMark()
        }
    }
}
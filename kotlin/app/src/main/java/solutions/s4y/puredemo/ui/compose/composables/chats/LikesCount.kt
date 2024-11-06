package solutions.s4y.puredemo.ui.compose.composables.chats

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun LikesCount(count: Int) {
    Text(text = "Likes: $count", color = Color.Green)
}
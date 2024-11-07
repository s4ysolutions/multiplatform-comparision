package solutions.s4y.puredemo.ui.compose.composables.chats

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import solutions.s4y.puredemo.R
import solutions.s4y.puredemo.ui.theme.HeartBackground

@Composable
fun LikesCount(likesCount: Int, new: Boolean) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(bottom = 16.dp, top = 16.dp)) {
        Box(
            modifier = Modifier
                .size(60.dp, 60.dp)
                .clip(CircleShape)
                .background(HeartBackground)
        )
        {
            Image(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "Likes",
                modifier = Modifier
                    .size(24.dp, 24.dp)
                    .align(Alignment.Center)
            )
        }
        Text(
            text = pluralStringResource(
                id = R.plurals.likes_count,
                count = likesCount,
                likesCount
            ),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f).padding(start = 16.dp, end = 16.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        if (new) {
            RowMark()
        }
    }
}
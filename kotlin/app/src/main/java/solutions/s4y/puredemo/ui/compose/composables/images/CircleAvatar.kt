package solutions.s4y.puredemo.ui.compose.composables.images

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale

@Composable
fun CircleAvatar(painter: Painter, contentDescription: String? = null, modifier: Modifier) {
    val scale = if (painter.intrinsicSize.width > painter.intrinsicSize.height) {
        ContentScale.FillHeight
    } else {
        ContentScale.FillWidth
    }
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier
            .clip(CircleShape),
        contentScale = scale
    )
}
package solutions.s4y.puredemo.ui.compose.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import solutions.s4y.puredemo.ui.compose.bottomsheets.BottomSheetAware
import solutions.s4y.puredemo.ui.theme.ChatsPanelBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatsPanel(content: @Composable BoxScope.() -> Unit) {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val subtractHeight = screenHeight / 5

    BoxWithConstraints(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
        val containerHeight = this.maxHeight
        val desiredHeight = containerHeight - subtractHeight
        BottomSheetAware {
            val containerWidth = if (isBottomSheetVisible)
                this@BoxWithConstraints.maxWidth - 32.dp
            else
                this@BoxWithConstraints.maxWidth
            Box(
                modifier = Modifier
                    .width(containerWidth)
                    .height(desiredHeight)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    .background(ChatsPanelBackground)
                    .padding(16.dp)
                    .align(Alignment.BottomCenter),
                content = content
            )
        }
    }
}
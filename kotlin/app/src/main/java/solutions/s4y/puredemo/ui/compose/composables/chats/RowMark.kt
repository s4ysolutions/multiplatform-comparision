package solutions.s4y.puredemo.ui.compose.composables.chats

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import solutions.s4y.puredemo.ui.theme.WhiteBrightest

@Composable
fun RowMark() {
    Canvas(
        modifier = Modifier
    ){
        drawCircle(
            color = WhiteBrightest,
            radius = 4f
        )
    }
}
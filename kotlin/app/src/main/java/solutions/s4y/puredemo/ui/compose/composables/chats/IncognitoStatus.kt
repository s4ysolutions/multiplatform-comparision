package solutions.s4y.puredemo.ui.compose.composables.chats

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import solutions.s4y.puredemo.R

@Composable
fun IncognitoStatus() {
    Text(
        text = stringResource(id = R.string.off).uppercase(),
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier.width(42.dp)
    )
}
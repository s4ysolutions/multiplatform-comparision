package solutions.s4y.puredemo.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val PureColorScheme = lightColorScheme(
    background = DesktopBackground,
    onSecondaryContainer = BottomAppBarSelectedIcon,
    onSurfaceVariant = BottomAppBarUnselectedIcon,
    secondaryContainer = BottomAppBarBackground,
    surface = TopAppBarBackground,
    surfaceContainer = BottomAppBarBackground,
)

@Composable
fun PuredemoTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = PureColorScheme,
        typography = Typography,
        content = content
    )
}
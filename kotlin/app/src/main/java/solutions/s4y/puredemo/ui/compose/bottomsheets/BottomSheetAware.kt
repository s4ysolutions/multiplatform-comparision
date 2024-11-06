package solutions.s4y.puredemo.ui.compose.bottomsheets

import androidx.compose.runtime.Composable

class BottomSheetScope(val isBottomSheetVisible: Boolean)

@Composable
fun BottomSheetAware(content: @Composable  BottomSheetScope.()->Unit) {
    val scope = BottomSheetScope(LocalComposableBuyIncognitoBottomSheetVisible.current.value)
    content(scope)
}
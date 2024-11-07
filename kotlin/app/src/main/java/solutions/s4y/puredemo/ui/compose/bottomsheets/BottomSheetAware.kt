package solutions.s4y.puredemo.ui.compose.bottomsheets

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

class BottomSheetScope(private val stateBottomSheetVisible: MutableState<Boolean>) {
    val isBottomSheetVisible: Boolean
        get() = stateBottomSheetVisible.value

    fun closeBottomSheet() {
        stateBottomSheetVisible.value = false
    }
}

@Composable
fun BottomSheetAware(content: @Composable  BottomSheetScope.()->Unit) {
    val scope = BottomSheetScope(LocalComposableBuyIncognitoBottomSheetVisible.current)
    content(scope)
}
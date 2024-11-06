@file:OptIn(ExperimentalMaterial3Api::class)

package solutions.s4y.puredemo.ui.compose.bottomsheets

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

val LocalComposableBuyIncognitoBottomSheetVisible =
    compositionLocalOf<MutableState<Boolean>> { error("Buy Incognito BottomSheet state is not provided") }

@Composable
fun BuyIncognitoBottomSheet() {
    val scope = rememberCoroutineScope()
    var visible by LocalComposableBuyIncognitoBottomSheetVisible.current
    if (!visible) {
        return
    }

    val sheetState = rememberModalBottomSheetState()
    ModalBottomSheet(
        onDismissRequest = {
            visible = false
        },
        sheetState = sheetState
    ) {
        Button(onClick = {
            scope.launch {
                sheetState.hide()
            }.invokeOnCompletion { visible = false }
        }) {
            Text("close")
        }
    }

}

@Composable
fun BuyIncognitoBottomSheetButton(content: @Composable RowScope.() -> Unit) {
    var visible by LocalComposableBuyIncognitoBottomSheetVisible.current
    Button(
        onClick = {
            visible = true
        },
        content = content
    )
}
@file:OptIn(ExperimentalMaterial3Api::class)

package solutions.s4y.puredemo.ui.compose.bottomsheets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import solutions.s4y.puredemo.ui.theme.BuyIncognitoButtonColors
import solutions.s4y.puredemo.R

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
fun BuyIncognitoBottomSheetButton() {
    var visible by LocalComposableBuyIncognitoBottomSheetVisible.current
    Button(
        modifier = Modifier.size(40.dp, 20.dp),
        colors = BuyIncognitoButtonColors,
        contentPadding = PaddingValues(0.dp),
        shape = RoundedCornerShape(20.dp),
        onClick = {
            visible = true
        },
    ) {
        Image(
            painter = painterResource(id = R.drawable.incognito),
            contentDescription = "Incognito",
            modifier = Modifier.width(30.dp)
        )
    }
}
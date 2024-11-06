package solutions.s4y.puredemo.ui.compose.bottomsheets

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetsHost(content: @Composable ()->Unit) {
    CompositionLocalProvider(
        LocalComposableBuyIncognitoBottomSheetVisible provides remember { mutableStateOf(false) }
    ) {
        content()
        BuyIncognitoBottomSheet()
    }
}

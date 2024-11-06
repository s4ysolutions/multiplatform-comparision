package solutions.s4y.puredemo.ui.compose.composables.chats

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import solutions.s4y.puredemo.ui.compose.bottomsheets.BuyIncognitoBottomSheetButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuyIncognitoButton() {
    BuyIncognitoBottomSheetButton{
        Text("Buy Incognito")
    }
}
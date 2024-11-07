@file:OptIn(ExperimentalMaterial3Api::class)

package solutions.s4y.puredemo.ui.compose.bottomsheets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import solutions.s4y.puredemo.ui.theme.BuyIncognitoButtonColors
import solutions.s4y.puredemo.R
import solutions.s4y.puredemo.ui.theme.BuyIncognitoBottomSheetButtonColors
import solutions.s4y.puredemo.ui.theme.PanelBorderColor
import solutions.s4y.puredemo.ui.theme.ProductBackground
import solutions.s4y.puredemo.ui.theme.TransparentButtonColors

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
        sheetState = sheetState,
    ) {
        /*
        Button(onClick = {
            scope.launch {
                sheetState.hide()
            }.invokeOnCompletion { visible = false }
        }) {*/
        Column(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.incognito_mode),
                    contentDescription = "Incognito",
                    modifier = Modifier
                        .height(68.dp)
                        .align(Alignment.Center)
                )
                Button(
                    onClick = {
                        scope.launch {
                            sheetState.hide()
                        }.invokeOnCompletion {
                            visible = false
                        }
                    },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(24.dp),
                    contentPadding = PaddingValues(0.dp),
                    colors = TransparentButtonColors
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cross),
                        contentDescription = "Close",
                        modifier = Modifier
                            .size(8.dp)
                    )
                }
            }
            Text(
                buildAnnotatedString {
                    append(stringResource(R.string.mode_incognito_24_1))
                    append(" ")
                    withStyle(style = SpanStyle(fontStyle = Italic)) {
                        append(stringResource(R.string.mode_incognito_24_2))
                    }
                    append(" ")
                    append(stringResource(R.string.mode_incognito_24_3))
                }.toUpperCase(),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                stringResource(R.string.mode_incognito_description),
                modifier = Modifier
                    .padding(top = 24.dp)
                    .align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.headlineSmall
            )
            Row(
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally)
            )
            {
                Product("1", price = "99 ₽")
                Spacer(modifier = Modifier.width(16.dp))
                Product("3", price = "199 ₽", higlight = stringResource(R.string.hit))
                Spacer(modifier = Modifier.width(16.dp))
                Product("7", price = "199 ₽", higlight = "-42%")
            }
            Button(
                onClick = {},
                colors = BuyIncognitoBottomSheetButtonColors,
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(stringResource(R.string.buy), style = MaterialTheme.typography.labelMedium)
            }
            Button(
                onClick = {},
                colors = TransparentButtonColors,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 24.dp)
            ) {
                Text(
                    stringResource(R.string.tems_conditions).uppercase(),
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
        //}
    }

}

@Composable
fun BuyIncognitoBottomSheetButton() {
    BottomSheetAware {
        var visible by LocalComposableBuyIncognitoBottomSheetVisible.current
        Button(
            modifier = Modifier.size(40.dp, 20.dp),
            colors = BuyIncognitoButtonColors,
            contentPadding = PaddingValues(0.dp),
            shape = RoundedCornerShape(20.dp),
            onClick = {
                visible = !visible
            },
        ) {
            if (visible) {
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.mic_off),
                        contentDescription = "Incognito",
                        modifier = Modifier.fillMaxHeight()
                    )
                }
            } else {
                Image(
                    painter = painterResource(id = R.drawable.incognito),
                    contentDescription = "Incognito",
                    modifier = Modifier.fillMaxHeight()
                )
            }
        }
    }
}

@Composable
fun Product(name: String, price: String, higlight: String? = null) {
    Box {
        Column(
            modifier = Modifier
                .padding(top = 14.dp)
                .width(100.dp)
                .clip(RoundedCornerShape(8.dp))
                .border(2.dp, PanelBorderColor, RoundedCornerShape(8.dp))
                .background(ProductBackground),
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(name)
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.incognito),
                    contentDescription = "Incognito",
                    modifier = Modifier
                        .height(12.dp)
                        .align(Alignment.CenterVertically)
                )
            }
            Text(
                price,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 16.dp)
                    .align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.labelMedium
            )
        }
        Image(
            painter = painterResource(id = R.drawable.bulb),
            contentDescription = "Incognito",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(75.dp, 25.dp)
        )
        if (higlight != null)
            Text(
                higlight,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top=7.dp),
                style = MaterialTheme.typography.labelSmall
            )
    }
}
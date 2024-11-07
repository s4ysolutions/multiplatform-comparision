package solutions.s4y.puredemo.ui.compose.composables.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import solutions.s4y.puredemo.R
import solutions.s4y.puredemo.ui.theme.FontUbuntu
import solutions.s4y.puredemo.ui.theme.Purlpe
import solutions.s4y.puredemo.ui.theme.TransparentButtonColors
import solutions.s4y.puredemo.ui.theme.WhiteBrightest

val temptationTextStyle = TextStyle(
    fontFamily = FontUbuntu,
    fontWeight = FontWeight.Light,
    fontStyle = FontStyle.Italic,
    fontSize = 13.sp,
    color = WhiteBrightest,
)

@Composable
fun CommonTemptations(modifier: Modifier) {
    Row(
        modifier = modifier
            .background(Purlpe)
            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val temptations = System.currentTimeMillis().toInt() % 20
        Image(
            painter = painterResource(id = R.drawable.rocket),
            contentDescription = null,
            modifier = Modifier
                .height(20.dp)
                .padding(start = 16.dp, end = 8.dp),
        )
        Text(
            pluralStringResource(R.plurals.common_temptations, temptations, temptations),
            modifier = Modifier.weight(1f),
            style = temptationTextStyle
        )
        Button(colors = TransparentButtonColors, onClick = {}) {
            Image(
                painter = painterResource(id = R.drawable.cross),
                contentDescription = null,
                modifier = Modifier.height(8.dp),
                colorFilter = ColorFilter.tint(WhiteBrightest)
            )
        }
    }
}
package solutions.s4y.puredemo.ui.compose.composables.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import solutions.s4y.puredemo.R
import solutions.s4y.puredemo.ui.theme.TransparentButtonColors
import solutions.s4y.puredemo.ui.theme.WhiteBrightest
import solutions.s4y.puredemo.ui.theme.WhiteDarkest

@Composable
fun ChatInput() {
    var value by remember { mutableStateOf("") }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Button(
            onClick = {},
            colors = TransparentButtonColors.copy(
                contentColor = WhiteDarkest
            ),
            modifier = Modifier.width(24.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.plus),
                contentDescription = null,
                modifier = Modifier.size(14.dp),
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        OutlinedTextField(
            value = value,
            onValueChange = { value = it },
            placeholder = { Text("Type here...", style = MaterialTheme.typography.displayMedium) },
            modifier = Modifier
                .weight(1f)
                //.height(33.dp)
                .padding(0.dp)
                .border(
                    width = 2.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(8.dp)
                ),
            singleLine = true,
            shape = RoundedCornerShape(8.dp),  // 8dp rounded corners
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.alien),
                    //painter = rememberVectorPainter(image = ImageVector.vectorResource(id = R.drawable.alien)),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = Color.Unspecified
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = WhiteBrightest,
                unfocusedBorderColor = WhiteDarkest,
                focusedBorderColor = WhiteBrightest,
            ),
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = {},
            colors = TransparentButtonColors.copy(
                contentColor = WhiteDarkest
            ),
            modifier = Modifier.width(24.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.mic),
                contentDescription = null,
                modifier = Modifier.size(14.dp),
                tint = Color.Unspecified
            )
        }
    }
}
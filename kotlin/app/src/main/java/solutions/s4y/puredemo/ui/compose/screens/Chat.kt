package solutions.s4y.puredemo.ui.compose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import solutions.s4y.puredemo.R
import solutions.s4y.puredemo.ui.compose.composables.ChatsPanel

@Composable
fun ChatScreen(id: String, modifier: Modifier, onBack: () -> Unit) {
    ChatsPanel {
        Column(modifier = modifier) {
            Button(onClick = {
                onBack()
            }) {
                Text(stringResource(R.string.chats))
            }
            Text("Chat $id -> 1")
            Text("Chat $id -> 2")
            Text("Chat $id -> 3")
            Text("Chat $id -> 4")
            Text("Chat $id -> 5")
            Text("Chat $id ->")
            Text("Chat $id ->")
        }
    }
}

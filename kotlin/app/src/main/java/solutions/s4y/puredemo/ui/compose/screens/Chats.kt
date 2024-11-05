package solutions.s4y.puredemo.ui.compose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import solutions.s4y.puredemo.R
import solutions.s4y.puredemo.ui.compose.locals.daggerViewMode
import solutions.s4y.puredemo.ui.viewmodels.ChatsViewModel

@Composable
fun ChatsScreen(viewModel: ChatsViewModel = daggerViewMode(),onSelectChat: (String) -> Unit) {
    Column {
        Greeting(stringResource(id = R.string.chats) + " " + viewModel.name);

        Button(onClick = {
            onSelectChat("12");
        }) {
            Text("Go to Chat")
        }
    }
}

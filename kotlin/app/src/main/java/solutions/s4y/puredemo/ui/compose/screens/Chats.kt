package solutions.s4y.puredemo.ui.compose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import solutions.s4y.puredemo.R
import solutions.s4y.puredemo.ui.compose.navigation.Routes
import solutions.s4y.puredemo.ui.viewmodels.ChatsViewModel

@Composable
fun ChatsScreen(viewModel: ChatsViewModel = viewModel(),onSelectChat: (String) -> Unit) {
    Column {
        Greeting(stringResource(id = R.string.chats) + " " + viewModel.name);

        Button(onClick = {
            onSelectChat("12");
        }) {
            Text("Go to Chat")
        }
    }
}

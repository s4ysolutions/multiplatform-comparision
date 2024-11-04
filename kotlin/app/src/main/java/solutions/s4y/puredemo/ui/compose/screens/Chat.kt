package solutions.s4y.puredemo.ui.compose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import solutions.s4y.puredemo.R
import solutions.s4y.puredemo.ui.compose.navigation.Routes
import solutions.s4y.puredemo.ui.viewmodels.ChatViewModel

@Composable
fun ChatScreen(id: String, viewModel: ChatViewModel = viewModel(), onBack: () -> Unit) {
    Column {
        Greeting("Chat $id" + " " + viewModel.name)

        Button(onClick = onBack)
        {
            Text("Go to Chat")
        }
    }
}

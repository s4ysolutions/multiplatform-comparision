package solutions.s4y.puredemo.ui.compose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import solutions.s4y.puredemo.R
import solutions.s4y.puredemo.ui.compose.composables.ChatsPanel
import solutions.s4y.puredemo.ui.compose.composables.chats.BuyIncognitoButton
import solutions.s4y.puredemo.ui.compose.composables.chats.ChatsList
import solutions.s4y.puredemo.ui.compose.composables.chats.ChatsListEmpty
import solutions.s4y.puredemo.ui.compose.composables.chats.IncognitoStatus
import solutions.s4y.puredemo.ui.compose.composables.chats.LikesCount
import solutions.s4y.puredemo.ui.compose.screens.composable.ScreenTitle
import solutions.s4y.puredemo.ui.viewmodels.ChatsViewModel
import solutions.s4y.puredemo.ui.viewmodels.Payload
import solutions.s4y.puredemo.ui.viewmodels.daggerViewModel

@Composable
fun ChatsScreen(modifier: Modifier = Modifier,  viewModel: ChatsViewModel = daggerViewModel(), onSelectChat: (String) -> Unit) {
    val likes by viewModel.likes.collectAsState()
    val chats by viewModel.chats.collectAsState()
    ChatsPanel {
        Column {
            Row {
                ScreenTitle(stringResource(R.string.chats))
                Spacer(modifier = Modifier.weight(1f))
                IncognitoStatus()
                BuyIncognitoButton()
            }
            LikesCount(likes, true)
            when (val result = chats) {
                is Payload.Loading -> {
                    ChatsListEmpty()
                }
                is Payload.Success -> {
                    ChatsList (result.data, onSelectChat )
                }
                is Payload.Error -> TODO()
            }
        }
    }
}

package solutions.s4y.puredemo.ui.compose.composables.chats

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import solutions.s4y.puredemo.ui.compose.locals.daggerViewModel
import solutions.s4y.puredemo.ui.viewmodels.ChatsViewModel
import solutions.s4y.puredemo.ui.viewmodels.Payload

@Composable
fun ChatsList(
    viewModel: ChatsViewModel = daggerViewModel(),
    onItemClick: (String) -> Unit
) {
    val chats by viewModel.chats.collectAsState()
    val likes by viewModel.likes.collectAsState()

    Column {
        BuyIncognitoButton()
        LikesCount(likes)
        when (val result = chats) {
            is Payload.Loading -> {
            }

            is Payload.Success -> {
                LazyColumn {
                    items(result.data.size) { index ->
                        val chatInfo = result.data[index]
                        ChatInfoListItem(chatInfo, onClick = {
                            onItemClick(chatInfo.imageUrl)
                        })
                    }
                }
            }

            is Payload.Error -> TODO()
        }
    }
}
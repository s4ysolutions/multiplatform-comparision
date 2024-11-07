package solutions.s4y.puredemo.ui.compose.composables.chats

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import solutions.s4y.puredemo.ca.domain.models.ChatInfo
import solutions.s4y.puredemo.ui.viewmodels.daggerViewModel
import solutions.s4y.puredemo.ui.viewmodels.ChatsViewModel
import solutions.s4y.puredemo.ui.viewmodels.Payload

@Composable
fun ChatsListEmpty(
) {
}
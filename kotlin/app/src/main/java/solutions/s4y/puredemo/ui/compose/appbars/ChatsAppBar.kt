package solutions.s4y.puredemo.ui.compose.appbars

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import solutions.s4y.puredemo.R
import solutions.s4y.puredemo.ui.compose.navigation.chatId
import solutions.s4y.puredemo.ui.viewmodels.ChatViewModel
import solutions.s4y.puredemo.ui.viewmodels.daggerViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import solutions.s4y.puredemo.ca.domain.models.ChatInfo
import solutions.s4y.puredemo.extension.resourceId
import solutions.s4y.puredemo.ui.compose.composables.images.CircleAvatar
import solutions.s4y.puredemo.ui.viewmodels.Payload

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatsAppBar(navController: NavController) {
    val chatId = navController.chatId ?: ""
    val model: ChatViewModel = daggerViewModel<ChatViewModel>()

    val chatInfo by (remember(
        model,
        chatId
    ) { model.chatFlow(chatId) }).collectAsState(Payload.Loading)
    println("===> chatInfo: $chatInfo")

    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.popBackStack()
                },
            ) {
                Icon(
                    Icons.AutoMirrored.Outlined.KeyboardArrowLeft,
                    contentDescription = stringResource(R.string.home),
                )
            }
        },
        actions = {
            IconButton(onClick = {
            }) {
                Icon(
                    Icons.Default.MoreVert,
                    contentDescription = stringResource(R.string.home),
                    tint= MaterialTheme.colorScheme.onSurface
                )
            }
        },
        // title = { image }
        title = {
            CircleAvatar(
                painter = painterResource(
                    //id = R.drawable.user2
                    id = if (chatInfo is Payload.Success) (chatInfo as Payload.Success<ChatInfo>).data.resourceId else R.drawable.user1,
                ),
                contentDescription = "",  // if (chatInfo is Payload.Success) (chatInfo as Payload.Success<ChatInfo>).data.imageUrl else null,
                modifier = Modifier
                    .size(30.dp)
            )
        }
    )
}
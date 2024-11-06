package solutions.s4y.puredemo.ui.compose.appbars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import solutions.s4y.puredemo.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatsAppBar(navController: NavController) {
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
                )
            }
        },
        title = { stringResource(R.string.chats) },
    )
}
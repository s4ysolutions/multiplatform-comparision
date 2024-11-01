package solutions.s4y.puredemo.ui.compose.bottombars

import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import solutions.s4y.puredemo.R
import solutions.s4y.puredemo.ui.compose.navigation.Routes

@Composable
fun MainBottomBar(navController: NavController) {
    BottomAppBar(
        actions = {
            IconButton(onClick = {
                navController.navigate(Routes.RoutesHome)
            }) {
                Icon(Icons.Outlined.Home, contentDescription = stringResource(R.string.home))
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {
                navController.navigate(Routes.RoutesChats)
            }) {
                Icon(Icons.Outlined.Person, contentDescription = stringResource(R.string.chats))
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {
                navController.navigate(Routes.RoutesFavorites)
            }) {
                Icon(
                    Icons.Outlined.Favorite,
                    contentDescription = stringResource(R.string.favorites)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {
                navController.navigate(Routes.RoutesSettings)
            }) {
                Icon(
                    Icons.Outlined.Settings,
                    contentDescription = stringResource(R.string.settings)
                )
            }
        })
}
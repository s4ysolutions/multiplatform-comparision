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
                navController.navigateClearBackStack(Routes.Home)
            }) {
                Icon(Icons.Outlined.Home, contentDescription = stringResource(R.string.home))
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {
                navController.navigateClearBackStack(Routes.Chats)
            }) {
                Icon(Icons.Outlined.Person, contentDescription = stringResource(R.string.chats))
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {
                navController.navigateClearBackStack(Routes.Favorites)
            }) {
                Icon(
                    Icons.Outlined.Favorite,
                    contentDescription = stringResource(R.string.favorites)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {
                navController.navigateClearBackStack(Routes.Settings)
            }) {
                Icon(
                    Icons.Outlined.Settings,
                    contentDescription = stringResource(R.string.settings)
                )
            }
        })
}

private fun NavController.navigateClearBackStack(route: Routes) {
    // dirty hack
    val routeString = route::class.qualifiedName
    if (currentDestination?.route == routeString) {
        return
    }
    val e = currentBackStackEntry
    navigate(route) {
        popUpTo(0) { inclusive = true }
        launchSingleTop = true
    }
}
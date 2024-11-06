package solutions.s4y.puredemo.ui.compose.appbars

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import solutions.s4y.puredemo.R
import solutions.s4y.puredemo.ui.compose.navigation.Routes
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import solutions.s4y.puredemo.ui.compose.navigation.isChats
import solutions.s4y.puredemo.ui.compose.navigation.isFavorites
import solutions.s4y.puredemo.ui.compose.navigation.isHome
import solutions.s4y.puredemo.ui.compose.navigation.isSettings

@Composable
fun MainBottomBar(navController: NavController) {
    val backStackEntry by navController.currentBackStackEntryAsState()

    BottomAppBar(
        contentPadding = PaddingValues(),
        windowInsets = WindowInsets(0,0,0,0),
        actions = {
            NavigationBarItem(
                icon = {
                    Icon(
                        painterResource(id = R.drawable.home),
                        contentDescription = stringResource(R.string.home),
                        modifier = Modifier.size(24.dp)
                    )
                },
                onClick = {
                    navController.navigateClearBackStack(Routes.Home)
                },
                selected = backStackEntry?.isHome == true,
            )
            NavigationBarItem(
                icon = {
                    Icon(
                        painterResource(id = R.drawable.chats),
                        contentDescription = stringResource(R.string.chats),
                        modifier = Modifier.size(24.dp)
                    )
                },
                onClick = {
                    navController.navigateClearBackStack(Routes.Chatting)
                },
                selected = backStackEntry?.isChats == true,
            )
            NavigationBarItem(
                icon = {
                    Icon(
                        painterResource(id = R.drawable.favorites),
                        contentDescription = stringResource(R.string.chats),
                        modifier = Modifier.size(24.dp)
                    )
                },
                onClick = {
                    navController.navigateClearBackStack(Routes.Favorites)
                },
                selected = backStackEntry?.isFavorites == true,
            )
            NavigationBarItem(
                icon = {
                    Icon(
                        painterResource(id = R.drawable.settings),
                        contentDescription = stringResource(R.string.chats),
                        modifier = Modifier.size(24.dp)
                    )
                },
                onClick = {
                    navController.navigateClearBackStack(Routes.Settings)
                },
                selected = backStackEntry?.isSettings == true,
            )
        }
    )
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


package solutions.s4y.puredemo.ui.compose.navigation

import kotlinx.serialization.Serializable

sealed class Routes {
    @Serializable
    object RoutesHome : Routes()
    @Serializable
    object RoutesChats : Routes()
    @Serializable
    object RoutesFavorites : Routes()
    @Serializable
    object RoutesSettings : Routes()
}

package solutions.s4y.puredemo.ui.compose.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
sealed class Routes(val path: String): Parcelable {
    @Parcelize
    object RoutesHome : Routes("home")
    @Parcelize
    object RoutesChats : Routes("chats")
    @Parcelize
    object RoutesFavorites : Routes("favorites")
    @Parcelize
    object RoutesSettings : Routes("settings")
}
/*
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
*/
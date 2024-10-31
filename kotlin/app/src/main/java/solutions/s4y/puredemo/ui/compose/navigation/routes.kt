package solutions.s4y.puredemo.ui.compose.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
sealed class Routes : Parcelable {
    object RoutesHome : Routes()
    object RoutesChats : Routes()
    object RoutesFavorites : Routes()
    object RoutesSettings : Routes()
}

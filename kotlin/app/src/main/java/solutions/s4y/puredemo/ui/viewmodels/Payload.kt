package solutions.s4y.puredemo.ui.viewmodels

sealed class Payload<out T> {
    object Loading : Payload<Nothing>()
    data class Success<out T>(val data: T) : Payload<T>()
    data class Error(val message: String, val error: Exception? = null) : Payload<Nothing>()
}
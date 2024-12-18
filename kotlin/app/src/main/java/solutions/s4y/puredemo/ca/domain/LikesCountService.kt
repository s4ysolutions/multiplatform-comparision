package solutions.s4y.puredemo.ca.domain

import kotlinx.coroutines.flow.StateFlow
import solutions.s4y.puredemo.ca.domain.dependencies.LikesCountProvider
import javax.inject.Inject

class LikesCountService @Inject constructor(
    private val likesCountProvider: LikesCountProvider,
) {
    val likesCount: StateFlow<Int> = likesCountProvider.likesCount
    fun connect() = likesCountProvider.connect()
    fun disconnect() = likesCountProvider.disconnect()
}
package solutions.s4y.puredemo.ca.domain

import kotlinx.coroutines.flow.StateFlow
import solutions.s4y.puredemo.ca.domain.dependencies.LikesCountProvider

class LikesCountService(
    private val likesCountProvider: LikesCountProvider,
) {
    val likesCount: StateFlow<Int> = likesCountProvider.likesCount
}
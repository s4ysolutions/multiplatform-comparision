package solutions.s4y.puredemo.ca.domain.dependencies

import kotlinx.coroutines.flow.StateFlow

interface LikesCountProvider {
    val likesCount: StateFlow<Int>
}
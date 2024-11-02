package solutions.s4y.puredemo.ca.bus

import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow


class LikesCounter(positiveRate: Float, averageDelayMs: Int, deviationMs: Int = 0) {
    private val _flow: MutableSharedFlow<Int> = MutableSharedFlow()

    private val job = Job()

    fun start(initial: Int = random0100()) {


    }


    companion object {
        fun random09(): Int = (System.currentTimeMillis() % 10).toInt()
        fun random0100(): Int = (System.currentTimeMillis() % 100).toInt()
    }
}
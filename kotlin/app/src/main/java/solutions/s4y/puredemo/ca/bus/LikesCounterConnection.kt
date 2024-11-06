package solutions.s4y.puredemo.ca.bus

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicReference

class LikesCounterConnection(positiveRate: Float, private val averageDelayMs: Int) {
    private val _flow: MutableStateFlow<Int> = MutableStateFlow(0)
    private val positiveRate = (positiveRate * 10).toInt()
    private val jobRef = AtomicReference<Job?>()

    val flow:StateFlow<Int> = _flow

    fun start(initial: Int) {
        jobRef.get()?.cancel()

        val job = Job()
        if (jobRef.compareAndSet(null, job)) {
            CoroutineScope(Dispatchers.Default + job).launch {
                var likes = initial
                while (isActive) {
                    _flow.emit(likes)
                    likes += if (random09() < positiveRate) 1 else -1
                    val delayDuration =
                        (averageDelayMs + (random0100() * random09()) - 500L).coerceAtLeast(0L)
                    delay(delayDuration)
                }
            }
        }
    }

    fun stop() {
        jobRef.getAndSet(null)?.cancel()
    }

    companion object {
        fun random09(): Int = (System.currentTimeMillis() % 10).toInt()
        fun random0100(): Int = (System.currentTimeMillis() % 100).toInt()
    }
}
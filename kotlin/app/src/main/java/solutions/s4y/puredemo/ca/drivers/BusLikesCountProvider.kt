package solutions.s4y.puredemo.ca.drivers

import solutions.s4y.puredemo.ca.bus.LikesCounterConnection
import solutions.s4y.puredemo.ca.domain.dependencies.LikesCountProvider

class BusLikesCountProvider(private val connection: LikesCounterConnection): LikesCountProvider  {
    override val likesCount = connection.flow
    override fun connect() = connection.start(10)
    override fun disconnect() = connection.stop()
}
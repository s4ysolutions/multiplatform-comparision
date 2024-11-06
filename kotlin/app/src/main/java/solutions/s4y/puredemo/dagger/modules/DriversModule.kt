package solutions.s4y.puredemo.dagger.modules

import dagger.Module
import dagger.Provides
import solutions.s4y.puredemo.ca.bus.LikesCounterConnection
import solutions.s4y.puredemo.ca.data.DaoDatabase
import solutions.s4y.puredemo.ca.domain.dependencies.ChatsRepository
import solutions.s4y.puredemo.ca.domain.dependencies.LikesCountProvider
import solutions.s4y.puredemo.ca.drivers.BusLikesCountProvider
import solutions.s4y.puredemo.ca.drivers.DaoChatInfoRepository
import solutions.s4y.puredemo.dagger.annotations.ApplicationScope
import javax.inject.Singleton

@Module
class DriversModule {
    companion object {
        @Provides
        @JvmStatic
        @ApplicationScope
        fun provideChatsRepository(database: DaoDatabase): ChatsRepository {
            return DaoChatInfoRepository(database)
        }

        @Provides
        @JvmStatic
        @ApplicationScope
        fun provideLikesCounter(): LikesCountProvider {
            val connection = LikesCounterConnection(0.75f, 750)
            return BusLikesCountProvider(connection)
        }
    }

}
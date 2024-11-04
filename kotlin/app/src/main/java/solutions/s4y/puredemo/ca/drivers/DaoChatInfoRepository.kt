package solutions.s4y.puredemo.ca.drivers

import solutions.s4y.puredemo.ca.data.TheDatabase
import solutions.s4y.puredemo.ca.domain.dependencies.ChatsRepository
import solutions.s4y.puredemo.ca.domain.models.ChatInfo
import javax.inject.Inject

class DaoChatInfoRepository @Inject constructor(private val theDatabase: TheDatabase) :
    ChatsRepository {
    override suspend fun getChats(): List<ChatInfo> =
        theDatabase.chatInfoDao().getAll().map {
            ChatInfo(
                it.imagerUrl,
                it.lastMessageTime,
                it.lastMessage,
                it.hasUnreadMessage,
                it.marked
            )
        }
}
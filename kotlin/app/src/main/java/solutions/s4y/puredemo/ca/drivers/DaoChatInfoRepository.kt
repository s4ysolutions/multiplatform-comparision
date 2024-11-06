package solutions.s4y.puredemo.ca.drivers

import solutions.s4y.puredemo.ca.data.DaoDatabase
import solutions.s4y.puredemo.ca.domain.dependencies.ChatsRepository
import solutions.s4y.puredemo.ca.domain.models.ChatInfo

class DaoChatInfoRepository constructor(private val daoDatabase: DaoDatabase) :
    ChatsRepository {
    override suspend fun getChats(): List<ChatInfo> =
        daoDatabase.chatInfoDao().getAll().map {
            ChatInfo(
                it.imagerUrl,
                it.lastMessageTime,
                it.lastMessage,
                it.hasUnreadMessage,
                it.marked
            )
        }
}
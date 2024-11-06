package solutions.s4y.puredemo.ca.domain

import solutions.s4y.puredemo.ca.domain.dependencies.ChatsRepository
import solutions.s4y.puredemo.ca.domain.models.ChatInfo
import javax.inject.Inject

class ChatsService @Inject constructor(private val chatsRepository: ChatsRepository) {
    suspend fun getChats(): List<ChatInfo> =
        chatsRepository.getChats()

    suspend fun getChatInfo(chatId: String): ChatInfo =
        chatsRepository.getChats().elementAt((chatId.toIntOrNull() ?: 1) - 1)
}
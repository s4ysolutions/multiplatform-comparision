package solutions.s4y.puredemo.ca.domain.dependencies

import solutions.s4y.puredemo.ca.domain.models.ChatInfo

interface ChatsRepository {
    suspend fun getChats(): List<ChatInfo>
}
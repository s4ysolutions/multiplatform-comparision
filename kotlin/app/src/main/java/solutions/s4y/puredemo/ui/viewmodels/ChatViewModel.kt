package solutions.s4y.puredemo.ui.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import solutions.s4y.puredemo.ca.domain.ChatsService
import solutions.s4y.puredemo.ca.domain.models.ChatInfo
import javax.inject.Inject

class ChatViewModel @Inject constructor(private val chatsService: ChatsService): ViewModel() {
    val name = "ChatViewModel"

    suspend fun getChat(chatId: String): ChatInfo  {
        return chatsService.getChatInfo(chatId)
    }

    fun chatFlow(chatId: String): Flow<Payload<ChatInfo>> = flow{
        emit(Payload.Loading)
        val chatInfo = chatsService.getChatInfo(chatId)
        emit(Payload.Success(chatInfo))
    }
}
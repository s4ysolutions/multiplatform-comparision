package solutions.s4y.puredemo.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import solutions.s4y.puredemo.ca.domain.ChatsService
import solutions.s4y.puredemo.ca.domain.LikesCountService
import solutions.s4y.puredemo.ca.domain.models.ChatInfo
import javax.inject.Inject

// @ChatsScreenScope
class ChatsViewModel @Inject constructor(
    private val chatsService: ChatsService,
    private val likesCountService: LikesCountService
) : ViewModel() {
    private val _chats = MutableStateFlow<Payload<List<ChatInfo>>>(Payload.Loading)
    val chats: StateFlow<Payload<List<ChatInfo>>> = _chats
    val likes: StateFlow<Int> = likesCountService.likesCount

    init {
        // TODO: error handling
        viewModelScope.launch {
            loadChats()
        }
        likesCountService.connect()
    }

    suspend fun loadChats() {
        _chats.value = Payload.Loading
        val info = chatsService.getChats()
        _chats.value = Payload.Success(info)
    }

    override fun onCleared() {
        super.onCleared()
        likesCountService.disconnect()
    }
}
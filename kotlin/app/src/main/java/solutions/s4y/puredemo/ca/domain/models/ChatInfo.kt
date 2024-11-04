package solutions.s4y.puredemo.ca.domain.models

class ChatInfo(
    val imageUrl: String,
    val lastMessageTime: String,
    val lastMessage: String,
    val hasUnreadMessage: Boolean,
    val marked: Boolean = false,
) {
    override fun toString(): String {
        return "ChatInfo(imageUrl='$imageUrl', lastMessageTime='$lastMessageTime', lastMessage='$lastMessage', hasUnreadMessage=$hasUnreadMessage, marked=$marked)"
    }
}
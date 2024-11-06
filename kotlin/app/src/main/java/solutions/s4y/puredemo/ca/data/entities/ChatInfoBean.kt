package solutions.s4y.puredemo.ca.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.TypeConverter
import java.util.Date

@Entity(tableName = "chat_info", primaryKeys = ["image_url"])
data class ChatInfoBean(
    @ColumnInfo(name = "image_url") val imagerUrl: String,
    @ColumnInfo(name = "last_message_time") val lastMessageTime: Date,
    @ColumnInfo(name = "last_message") val lastMessage: String,
    @ColumnInfo(name = "has_unread_message") val hasUnreadMessage: Boolean,
    @ColumnInfo(name = "marked") val marked: Boolean = false,
)
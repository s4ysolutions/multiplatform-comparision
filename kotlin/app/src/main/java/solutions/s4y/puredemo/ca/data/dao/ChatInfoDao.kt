package solutions.s4y.puredemo.ca.data.dao

import androidx.room.Dao
import androidx.room.Query
import solutions.s4y.puredemo.ca.data.entities.ChatInfoBean

@Dao
abstract class ChatInfoDao {
    @Query("SELECT * FROM chat_info")
    abstract suspend fun getAll(): List<ChatInfoBean>
}
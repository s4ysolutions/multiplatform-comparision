package solutions.s4y.puredemo.data.dao

import androidx.room.Dao
import androidx.room.Query
import solutions.s4y.puredemo.data.entities.ChatInfo

@Dao
abstract class ChatInfoDao {
    @Query("SELECT * FROM chat_info")
    abstract suspend fun getAll(): List<ChatInfo>
    suspend fun getById(id: Int)=getAll().getOrNull(id)
}
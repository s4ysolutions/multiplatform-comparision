package solutions.s4y.puredemo.ca.data

import androidx.room.Database
import androidx.room.RoomDatabase
import solutions.s4y.puredemo.ca.data.dao.ChatInfoDao
import solutions.s4y.puredemo.ca.data.entities.ChatInfoBean


@Database(entities = [ChatInfoBean::class], version = 1)
abstract class TheDatabase: RoomDatabase() {
    abstract fun chatInfoDao(): ChatInfoDao
}
package solutions.s4y.puredemo.ca.data

import androidx.room.Database
import androidx.room.RoomDatabase
import solutions.s4y.puredemo.ca.data.dao.ChatInfoDao
import solutions.s4y.puredemo.ca.data.entities.ChatInfo


@Database(entities = [ChatInfo::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract fun chatInfoDao(): ChatInfoDao
}
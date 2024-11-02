package solutions.s4y.puredemo.drive

import androidx.room.Database
import androidx.room.RoomDatabase
import solutions.s4y.puredemo.drive.dao.ChatInfoDao
import solutions.s4y.puredemo.drive.entities.ChatInfo


@Database(entities = [ChatInfo::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract fun chatInfoDao(): ChatInfoDao
}
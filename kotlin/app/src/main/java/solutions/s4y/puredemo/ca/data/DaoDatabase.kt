package solutions.s4y.puredemo.ca.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import solutions.s4y.puredemo.ca.data.dao.ChatInfoDao
import solutions.s4y.puredemo.ca.data.entities.ChatInfoBean
import java.util.Date


class DateConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}

@Database(entities = [ChatInfoBean::class], version = 2)
@TypeConverters(DateConverter::class)
abstract class DaoDatabase: RoomDatabase() {
    abstract fun chatInfoDao(): ChatInfoDao
}
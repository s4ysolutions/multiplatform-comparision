package solutions.s4y.puredemo.dagger.modules

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import solutions.s4y.puredemo.ca.data.TheDatabase
import solutions.s4y.puredemo.dagger.annotations.ApplicationScope

@Module
class AssetDaoDb {
    companion object {
        @Provides
        @JvmStatic
        fun provideAssetDaoBuilder(context: Context): RoomDatabase.Builder<TheDatabase> {
            return Room.databaseBuilder(context, TheDatabase::class.java, "asset-db")
                .createFromAsset("pre-populated.db")
        }

        @Provides
        @JvmStatic
        @ApplicationScope
        fun provideAssetDao(builder: RoomDatabase.Builder<TheDatabase>): TheDatabase {
            return builder.build()
        }
    }
}
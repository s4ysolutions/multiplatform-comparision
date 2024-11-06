package solutions.s4y.puredemo.dagger.modules

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import solutions.s4y.puredemo.ca.data.DaoDatabase
import solutions.s4y.puredemo.dagger.annotations.ApplicationScope

@Module
class AssetDaoDbModule {
    companion object {
        @Provides
        @JvmStatic
        fun provideAssetDaoBuilder(context: Context): RoomDatabase.Builder<DaoDatabase> {
            return Room.databaseBuilder(context, DaoDatabase::class.java, "asset-db")
                .createFromAsset("pre-populated.db")
        }

        @Provides
        @JvmStatic
        @ApplicationScope
        fun provideAssetDao(builder: RoomDatabase.Builder<DaoDatabase>): DaoDatabase {
            return builder.build()
        }
    }
}
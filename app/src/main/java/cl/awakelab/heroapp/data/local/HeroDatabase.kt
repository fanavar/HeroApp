package cl.awakelab.heroapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cl.awakelab.heroapp.data.local.detail.HeroDetailEntity
import cl.awakelab.heroapp.data.local.list.HeroEntity

@Database(entities = [HeroEntity::class, HeroDetailEntity::class], version = 4)
abstract class HeroDatabase: RoomDatabase() {
    abstract fun getHeroDao(): HeroDao

    companion object {
        @Volatile
        private var INSTANCE: HeroDatabase? = null

        fun getDatabase(context: Context): HeroDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HeroDatabase::class.java,

                    "phone_database"
                ).fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }
}
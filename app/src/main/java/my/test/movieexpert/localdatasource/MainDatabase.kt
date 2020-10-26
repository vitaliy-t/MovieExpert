package my.test.movieexpert.localdatasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import my.test.movieexpert.localdatasource.dao.PopularMovieDao
import my.test.movieexpert.profilescreen.model.PopularMovie
import my.test.movieexpert.utilities.DATABASE_NAME

@Database(
    entities = [PopularMovie::class],
    version = 1,
    exportSchema = false
)
abstract class MainDatabase : RoomDatabase() {

    abstract fun popularMovieDao(): PopularMovieDao

    companion object {
        @Volatile
        private var instance: MainDatabase? = null

        fun getInstance(context: Context): MainDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): MainDatabase {
            return Room.databaseBuilder(context, MainDatabase::class.java, DATABASE_NAME).build()
        }
    }
}

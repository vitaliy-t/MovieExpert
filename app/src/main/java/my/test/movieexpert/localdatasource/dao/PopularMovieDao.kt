package my.test.movieexpert.localdatasource.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import my.test.movieexpert.profilescreen.model.PopularMovie

@Dao
interface PopularMovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovies(listOfMovies: List<PopularMovie>)

    @Query("DELETE FROM PopularMovie")
    suspend fun clearTable()

    @Query("SELECT * FROM PopularMovie")
    suspend fun getMovies(): List<PopularMovie>?

    @Query("SELECT * FROM PopularMovie WHERE id = :id")
    suspend fun getMovieById(id: Int): PopularMovie
}
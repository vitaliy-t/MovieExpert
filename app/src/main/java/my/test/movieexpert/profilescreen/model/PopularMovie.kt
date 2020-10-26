package my.test.movieexpert.profilescreen.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import java.io.Serializable

@Entity
data class PopularMovie(
    @field:Json(name = "id") @ColumnInfo(name = "id") val id: Int,
    @field:Json(name = "title") @ColumnInfo(name = "title") val title: String,
    @field:Json(name = "overview") @ColumnInfo(name = "overview") val overview: String,
    @field:Json(name = "release_date") @ColumnInfo(name = "release_date") val release_date: String,
    @field:Json(name = "poster_path") @ColumnInfo(name = "poster_path") val poster_path: String?,
    @field:Json(name = "vote_average") @ColumnInfo(name = "vote_average") val vote_average: String
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "rowId")
    var rowId: Int = 0
}
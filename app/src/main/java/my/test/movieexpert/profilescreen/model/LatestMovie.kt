package my.test.movieexpert.profilescreen.model

import android.content.Context
import com.squareup.moshi.Json
import my.test.movieexpert.R

data class LatestMovie(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "title") val title: String,
    @field:Json(name = "overview") val overview: String,
    @field:Json(name = "vote_average") val vote_average: String,
    @field:Json(name = "release_date") val release_date: String,
    @field:Json(name = "poster_path") val poster_path: String?,
    @field:Json(name = "adult") val adult: Boolean,
    @field:Json(name = "original_language") val originalLang: String,
    @field:Json(name = "original_title") val originalTitle: String,
    @field:Json(name = "budget") val budget: String,
    @field:Json(name = "revenue") val revenue: String,
    @field:Json(name = "runtime") val runtime: String,
    @field:Json(name = "popularity") val popularity: String,
    @field:Json(name = "status") val status: String,
) {
    companion object {
        fun LatestMovie.prepForDisplay(context: Context): LatestMovie {
            return LatestMovie(
                id = this.id,
                title = context.getString(R.string.home_latest_movie_title, this.title),
                overview = context.getString(R.string.home_latest_movie_overview, this.overview),
                vote_average = context.getString(R.string.home_latest_movie_rating, this.vote_average),
                release_date = context.getString(R.string.home_latest_movie_release_date, this.release_date),
                poster_path = this.poster_path,
                adult = this.adult,
                originalLang = context.getString(R.string.home_latest_movie_original_language, this.originalLang),
                originalTitle = context.getString(R.string.home_latest_movie_original_Title, this.originalTitle),
                budget = context.getString(R.string.home_latest_movie_budget, this.budget),
                revenue = context.getString(R.string.home_latest_movie_revenue, this.revenue),
                runtime = context.getString(R.string.home_latest_movie_runtime, this.runtime),
                popularity = context.getString(R.string.home_latest_movie_popularity, this.popularity),
                status = context.getString(R.string.home_latest_movie_status, this.status)
            )
        }
    }
}
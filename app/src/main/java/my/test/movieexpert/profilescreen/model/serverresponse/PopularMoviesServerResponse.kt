package my.test.movieexpert.profilescreen.model.serverresponse

import com.squareup.moshi.Json
import my.test.movieexpert.profilescreen.model.PopularMovie

data class PopularMoviesServerResponse(
    @field:Json(name = "page") val page: Int,
    @field:Json(name = "results") val results: List<PopularMovie>,
    @field:Json(name = "total_results") val total_results: Int,
    @field:Json(name = "total_pages") val total_pages: Int
)
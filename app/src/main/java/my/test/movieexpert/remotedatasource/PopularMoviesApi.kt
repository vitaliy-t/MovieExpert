package my.test.movieexpert.remotedatasource

import my.test.movieexpert.profilescreen.model.serverresponse.PopularMoviesServerResponse
import my.test.movieexpert.utilities.TMDB_API_BASE_URL
import my.test.movieexpert.utilities.TMDB_API_KEY
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PopularMoviesApi {
    @Headers("Accept: application/json")
    @GET("movie/popular")
    suspend fun getMovies(
        @Query("api_key") key: String = TMDB_API_KEY,
        @Query("page") page: Int = 1
    ): Response<PopularMoviesServerResponse>

    companion object {
        fun getInstance(): PopularMoviesApi {
            return Retrofit.Builder()
                .baseUrl(TMDB_API_BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(PopularMoviesApi::class.java)
        }
    }
}
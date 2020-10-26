package my.test.movieexpert.profilescreen.model.state.movies

import my.test.movieexpert.profilescreen.model.PopularMovie
import my.test.movieexpert.profilescreen.model.serverresponse.PopularMoviesServerResponse

sealed class PopularMoviesState {
    object Loading : PopularMoviesState()
    data class Content(val response: PopularMoviesServerResponse) : PopularMoviesState()
    data class Failure(val errorMessage: String, val cachedListOfMovies: List<PopularMovie>) : PopularMoviesState()
}
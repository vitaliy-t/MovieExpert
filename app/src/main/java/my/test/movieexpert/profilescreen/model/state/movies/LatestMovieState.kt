package my.test.movieexpert.profilescreen.model.state.movies

import my.test.movieexpert.profilescreen.model.LatestMovie

sealed class LatestMovieState {
    object Loading : LatestMovieState()
    data class Content(val latestMovie: LatestMovie) : LatestMovieState()
    data class Failure(val errorMessage: String) : LatestMovieState()
}
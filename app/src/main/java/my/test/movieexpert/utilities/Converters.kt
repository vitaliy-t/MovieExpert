@file:JvmName("Converters")

package my.test.movieexpert.utilities

import android.view.View
import my.test.movieexpert.profilescreen.model.state.movies.LatestMovieState

fun booleanToVisibility(bool: Boolean): Int {
    return if (bool) {
        View.VISIBLE
    } else {
        View.INVISIBLE
    }
}

fun latestMovieStateToIsAdult(state: LatestMovieState): Boolean? {
    return if (state is LatestMovieState.Content) {
        state.latestMovie.adult
    } else {
        null
    }
}


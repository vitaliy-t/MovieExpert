package my.test.movieexpert.profilescreen.bindingAdapters

import android.view.View
import androidx.databinding.BindingAdapter
import my.test.movieexpert.profilescreen.model.state.movies.LatestMovieState

object HomeBindingAdapters {
    @BindingAdapter("setLatestMovieErrorUiVisibility")
    @JvmStatic
    fun View.setErrorVisibility(state: LatestMovieState) {
        if (state is LatestMovieState.Failure) {
            this.visibility = View.VISIBLE
        } else {
            this.visibility = View.GONE
        }
    }

    @BindingAdapter("setLatestMovieContentUiVisibility")
    @JvmStatic
    fun View.setContentVisibility(state: LatestMovieState) {
        if (state is LatestMovieState.Content) {
            if (state.latestMovie.adult) {
                this.visibility = View.GONE
            } else {
                this.visibility = View.VISIBLE
            }
        } else if (state is LatestMovieState.Loading) {
            this.visibility = View.VISIBLE
        } else {
            this.visibility = View.GONE
        }
    }
}
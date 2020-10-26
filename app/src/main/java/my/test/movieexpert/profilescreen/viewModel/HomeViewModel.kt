package my.test.movieexpert.profilescreen.viewModel

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import my.test.movieexpert.profilescreen.model.LatestMovie
import my.test.movieexpert.profilescreen.model.LatestMovie.Companion.prepForDisplay
import my.test.movieexpert.profilescreen.model.state.movies.LatestMovieState
import my.test.movieexpert.repository.MainRepository

class HomeViewModel @ViewModelInject constructor(
    @ApplicationContext private val context: Context,
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _latestMovieState = MutableLiveData<LatestMovieState>()
    val latestMovieState: LiveData<LatestMovieState>
        get() = _latestMovieState

    val latestMovie = MediatorLiveData<LatestMovie>().apply {
        addSource(_latestMovieState) {
            value = if (it is LatestMovieState.Content) it.latestMovie.prepForDisplay(context) else null
        }
    }

    init {
        fetchLatestMovie()
    }

    fun fetchLatestMovie() {
        _latestMovieState.value = LatestMovieState.Loading

        viewModelScope.launch {
            _latestMovieState.value = mainRepository.fetchLatestMovie()
        }
    }
}
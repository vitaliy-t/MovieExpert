package my.test.movieexpert.profilescreen.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import my.test.movieexpert.profilescreen.model.PopularMovie
import my.test.movieexpert.profilescreen.model.state.movies.PopularMoviesState
import my.test.movieexpert.repository.MainRepository

class MoviesViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _popularMoviesState = MutableLiveData<PopularMoviesState>()
    val popularMoviesState: LiveData<PopularMoviesState>
        get() = _popularMoviesState

    private val _popularMovieById = MutableLiveData<PopularMovie>()
    val popularMovieById: LiveData<PopularMovie>
        get() = _popularMovieById

    private var currentPage: Int = 1

    init {
        fetchPopularMovies()
    }

    fun fetchPopularMovies(page: Int = currentPage) {
        _popularMoviesState.value = PopularMoviesState.Loading

        viewModelScope.launch {
            _popularMoviesState.value = mainRepository.fetchPopularMovies(page = page)
        }
    }

    fun fetchPopularMovieById(id: Int) {
        _popularMovieById.value = null
        viewModelScope.launch {
            _popularMovieById.value = mainRepository.fetchPopularMovieById(id)
        }
    }

    fun nextPage() {
        if (currentPage != 500) {
            fetchPopularMovies(currentPage + 1)
            currentPage++
        } else
            fetchPopularMovies()
    }

    fun previousPage() {
        if (currentPage > 1) {
            fetchPopularMovies(currentPage - 1)
            currentPage--
        } else
            fetchPopularMovies()
    }
}
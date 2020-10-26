package my.test.movieexpert.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import my.test.movieexpert.localdatasource.dao.PopularMovieDao
import my.test.movieexpert.profilescreen.model.PopularMovie
import my.test.movieexpert.profilescreen.model.serverresponse.ErrorResponse
import my.test.movieexpert.profilescreen.model.state.movies.LatestMovieState
import my.test.movieexpert.profilescreen.model.state.movies.PopularMoviesState
import my.test.movieexpert.remotedatasource.LatestMovieApi
import my.test.movieexpert.remotedatasource.PopularMoviesApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(
    private val popularMovieDao: PopularMovieDao,
    private val popularMoviesApi: PopularMoviesApi,
    private val latestMovieApi: LatestMovieApi,
    private val auth: FirebaseAuth
) {
    fun isUserLoggedIn() = auth.currentUser != null
    fun getCurrentFirebaseUser(): FirebaseUser? {
        return auth.currentUser
    }

    fun userLogout() = auth.signOut()

    suspend fun fetchPopularMovies(page: Int = 1) = try {
        val response = popularMoviesApi.getMovies(page = page)

        if (response.code() == 200) {
            savePopularMoviesToCache(response.body()!!.results)
            PopularMoviesState.Content(response.body()!!)
        } else {
            PopularMoviesState.Failure(
                ErrorResponse.parse(response).message,
                popularMovieDao.getMovies() ?: listOf()
            )
        }
    } catch (error: Throwable) {
        PopularMoviesState.Failure(
            error.localizedMessage!!,
            popularMovieDao.getMovies() ?: listOf()
        )
    }

    suspend fun fetchPopularMovieById(id: Int) = popularMovieDao.getMovieById(id)

    suspend fun fetchLatestMovie() = try {
        val response = latestMovieApi.getMovie()

        if (response.code() == 200) {
            LatestMovieState.Content(response.body()!!)
        } else {
            LatestMovieState.Failure(ErrorResponse.parse(response).message)
        }
    } catch (error: Throwable) {
        LatestMovieState.Failure(error.localizedMessage!!)
    }

    private suspend fun savePopularMoviesToCache(listOfMovies: List<PopularMovie>) {
        popularMovieDao.clearTable()
        popularMovieDao.addMovies(listOfMovies)
    }
}
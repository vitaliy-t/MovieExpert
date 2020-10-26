package my.test.movieexpert.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import my.test.movieexpert.remotedatasource.LatestMovieApi
import my.test.movieexpert.remotedatasource.PopularMoviesApi
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RemoteDataSourceModule {

    @Singleton
    @Provides
    fun providePopularMoviesApi(): PopularMoviesApi = PopularMoviesApi.getInstance()

    @Singleton
    @Provides
    fun provideLatestMovieApi(): LatestMovieApi = LatestMovieApi.getInstance()

}
package my.test.movieexpert.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import my.test.movieexpert.localdatasource.MainDatabase
import my.test.movieexpert.localdatasource.dao.PopularMovieDao
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object LocalDataSourceModule {
    @Singleton
    @Provides
    fun provideMainDatabase(@ApplicationContext context: Context): MainDatabase = MainDatabase.getInstance(context)

    @Provides
    fun providePopularMovieDao(mainDatabase: MainDatabase): PopularMovieDao = mainDatabase.popularMovieDao()
}
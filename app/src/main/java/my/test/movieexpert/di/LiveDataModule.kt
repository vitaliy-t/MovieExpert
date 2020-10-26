package my.test.movieexpert.di

import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
object LiveDataModule {

    @Provides
    fun provideMutableLiveDataOfString(): MutableLiveData<String> = MutableLiveData<String>()
}
package my.test.movieexpert.splashscreen.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import my.test.movieexpert.repository.MainRepository

class SplashViewModel @ViewModelInject constructor(
    val mainRepository: MainRepository
) : ViewModel() {

    fun isUserLoggedIn() = mainRepository.isUserLoggedIn()

}
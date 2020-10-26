package my.test.movieexpert.splashscreen.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import my.test.movieexpert.R
import my.test.movieexpert.splashscreen.viewModel.SplashViewModel
import my.test.movieexpert.utilities.proceedToLoginScreen
import my.test.movieexpert.utilities.proceedToProfileScreen

@AndroidEntryPoint
class SplashScreenActivity : AppCompatActivity() {

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        if (splashViewModel.isUserLoggedIn())
            proceedToProfileScreen(this)
        else
            proceedToLoginScreen(this)

    }
}
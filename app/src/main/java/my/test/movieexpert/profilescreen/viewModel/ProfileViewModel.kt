package my.test.movieexpert.profilescreen.viewModel

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.qualifiers.ApplicationContext
import my.test.movieexpert.profilescreen.model.state.profile.EmailVerificationState
import my.test.movieexpert.profilescreen.model.state.profile.LoggedInState
import my.test.movieexpert.repository.MainRepository

class ProfileViewModel @ViewModelInject constructor(
    @ApplicationContext context: Context,
    private val mainRepository: MainRepository
) : ViewModel() {
    val user: FirebaseUser = mainRepository.getCurrentFirebaseUser()!!
    val isEmailVerified = user.isEmailVerified

    private val _loggedInState = MutableLiveData<LoggedInState>()
    val loggedInState: LiveData<LoggedInState>
        get() = _loggedInState

    private val _emailVerificationState = MutableLiveData<EmailVerificationState>()
    val emailVerificationState: LiveData<EmailVerificationState>
        get() = _emailVerificationState

    init {
        _loggedInState.value = LoggedInState.LoggedIn
    }

    fun sendUserVerificationEmail() {
        _emailVerificationState.value = EmailVerificationState.Loading

        user.sendEmailVerification()
            .addOnCompleteListener {
                _emailVerificationState.value =
                    if (it.isSuccessful)
                        EmailVerificationState.Sent
                    else
                        EmailVerificationState.Error(it.exception!!.localizedMessage!!)
            }
    }

    fun userLogout() {
        mainRepository.userLogout()
        _loggedInState.value = LoggedInState.LoggedOut

    }
}
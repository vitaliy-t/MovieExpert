package my.test.movieexpert.loginscreen.model.state

sealed class SignInState {
    object Loading : SignInState()
    object SignedIn : SignInState()
    data class Error(val errorMessage: String) : SignInState()
}
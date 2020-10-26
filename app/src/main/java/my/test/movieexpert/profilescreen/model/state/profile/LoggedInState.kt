package my.test.movieexpert.profilescreen.model.state.profile

sealed class LoggedInState {
    object LoggedIn : LoggedInState()
    object LoggedOut : LoggedInState()
}
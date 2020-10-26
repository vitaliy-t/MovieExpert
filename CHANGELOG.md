#Movie Expert with pure MVVM architecture.
version 0.9.3:
- Added `ErrorResponse` class which will be used to handle server error responses from Retrofit.
- `IPopularMovie` renamed to `PopularMoviesApi` for better readability.
- Implemented fully working `Home` fragment with latest movie displayed inside of it.
- Implemented adult content filtering. (If the latest movie is adult, you will not be able to see it)
- Reworked `MovieDetails` fragment. It now uses local cached data for displaying movie information.
- Final `Lint` inspection.
- Code clean up.

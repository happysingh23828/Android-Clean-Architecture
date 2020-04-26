<p align="center">
 <center><img width="100%%"  src="files/android_clean_architecture.png"></a></center>
</p>

# Android Clean Architecture 
[![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
![Android CI](https://github.com/happysingh23828/Android-Clean-Architecture/workflows/Android%20CI/badge.svg)
[![GitHub license](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
![Github Followers](https://img.shields.io/github/followers/happysingh23828?label=Follow&style=social)
![GitHub stars](https://img.shields.io/github/stars/happysingh23828/Android-Clean-Architecture?style=social)
![GitHub forks](https://img.shields.io/github/forks/happysingh23828/Android-Clean-Architecture?style=social)
![GitHub watchers](https://img.shields.io/github/watchers/happysingh23828/Android-Clean-Architecture?style=social)
![Twitter Follow](https://img.shields.io/twitter/follow/happysingh23828?label=Follow&style=social)

This is a sample movie list  Android application 📱 built to demonstrate use of *Clean Architecture* tools. Dedicated to all Android Developers with ❤️. 

***You can Install and test latest app from below 👇***

[![Clean Architecture App](https://img.shields.io/badge/CleanArchitecture🍲-APK-red.svg?style=for-the-badge&logo=android)](https://github.com/happysingh23828/raw/master/Android-Clean-Architecture/files/clean-arc.apk)


## About
It simply loads **Popular Movies** list from [TMDB-API](https://www.themoviedb.org/)  and stores it in persistence storage (i.e. Room Database). Movies list will be always loaded from local database. Remote data (from API) and Local data is always synchronized.
It has feature of bookmark movie which will be stored locally.
- Modular approch followed
- It is heavily implemented by following standard clean architecture principle.
- Offline capability.
- It has cache expiration feature [5 minutes].
- Unit testing written for all layers.
- Multi Module Code Coverage reports using Jacoco.
- Android CI github action integration. 
- [S.O.L.I.D](https://en.wikipedia.org/wiki/SOLID) priciple followed for more understandable, flexible and maintainable.

### Disclaimer

Note: The use of clean architecture may seem over-complicated for this sample project. However, this allows us to keep the amount of boilerplate code to a minimum and also demonstrate the approach in a simpler form.

Clean Architecture will not be appropriate for every project, so it is down to you to decide whether or not it fits your needs 🙂

## Built With 🛠
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Rx-Java](https://github.com/ReactiveX/RxJava) - For composing asynchronous and event-based programs by using observable sequences.
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Data objects that notify views when the underlying database changes.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes. 
  - [Room](https://developer.android.com/topic/libraries/architecture/room) - SQLite object mapping library.
- [Dagger 2](https://dagger.dev/) - Dependency Injection Framework
- [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.
- [OkHttp](http://square.github.io/okhttp/) - HTTP client that's efficient by default: HTTP/2 support allows all requests to the same host to share a socket
- [Glide](https://github.com/bumptech/glide) - image loading framework for Android
- [Gson](https://github.com/google/gson) - used to convert Java Objects into their JSON representation and vice versa.
- [Mockito](http://site.mockito.org/) - Most popular mocking framework for Java/kotlin.
- [Robolectric](http://robolectric.org/) - allows you to write unit tests and run them on a desktop JVM while still using Android API.
- [Stetho](https://github.com/facebook/stetho) - Stetho is a debug bridge for Android applications, enabling the powerful Chrome Developer Tools and much more.

## Architecture


## Thanks

A special thanks to the authors involved with this repository, they were a great resource during our learning!
- https://github.com/bufferapp/android-clean-architecture-mvi-boilerplate

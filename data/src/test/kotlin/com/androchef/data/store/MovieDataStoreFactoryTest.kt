package com.androchef.data.store

import com.androchef.data.repository.MoviesCache
import com.androchef.data.repository.MoviesRemote
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieDataStoreFactoryTest {

    @Mock
    lateinit var movieCache: MoviesCache

    @Mock
    lateinit var movieRemote: MoviesRemote

    private lateinit var movieCacheDataStore: MovieCacheDataStore

    private lateinit var movieRemoteDataStore: MovieRemoteDataStore

    private lateinit var movieDataStoreFactory: MovieDataStoreFactory

    @Before
    fun setUp() {
        movieCacheDataStore = MovieCacheDataStore(movieCache)
        movieRemoteDataStore = MovieRemoteDataStore(movieRemote)
        movieDataStoreFactory =
            MovieDataStoreFactory(movieCache, movieCacheDataStore, movieRemoteDataStore)
    }

    @Test
    fun movieDataStoreFactory_getDataStore_noCache_returnRemoteStore() {
        // Arrange
        stubMovieCacheIsCached(Single.just(false))

        // Act
        val movieDataStore = movieDataStoreFactory.getDataStore(false)

        // Assert
        assert(movieDataStore is MovieRemoteDataStore)
    }

    @Test
    fun movieDataStoreFactory_getDataStore_expiredCache_returnRemoteStore() {
        // Arrange
        stubMovieCacheIsCached(Single.just(true))
        stubMovieCacheIsExpired(true)

        // Act
        val movieDataStore = movieDataStoreFactory.getDataStore(true)

        // Assert
        assert(movieDataStore is MovieRemoteDataStore)
    }

    @Test
    fun movieDataStoreFactory_getDataStore_returnRemoteDataStore() {
        // Act
        val movieDataStore = movieDataStoreFactory.getRemoteDataStore()

        // Assert
        assert(movieDataStore is MovieRemoteDataStore)
    }

    @Test
    fun movieDataStoreFactory_getDataStore_returnCacheDataStore() {
        // Act
        val movieDataStore = movieDataStoreFactory.getCacheDataStore()

        // Assert
        assert(movieDataStore is MovieCacheDataStore)
    }

    /**
     * Stub helper methods
     */
    private fun stubMovieCacheIsCached(single: Single<Boolean>) {
        `when`(movieCache.isCached())
            .thenReturn(single)
    }

    private fun stubMovieCacheIsExpired(isExpired: Boolean) {
        `when`(movieCache.isExpired()).thenReturn(isExpired)
    }
}

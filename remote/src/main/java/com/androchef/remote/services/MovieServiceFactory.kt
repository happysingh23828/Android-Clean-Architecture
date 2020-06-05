package com.androchef.remote.services

import com.androchef.remote.services.intercepter.AuthorizationInterceptor
import com.google.gson.Gson
import java.util.concurrent.TimeUnit
import okhttp3.Dns
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object MovieServiceFactory {

    fun create(isDebugMode: Boolean, baseUrl: String, apiKey: String): MoviesService {
        val client = createOkHttp(isDebugMode, apiKey)

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()

        return retrofit.create(MoviesService::class.java)
    }

    private fun createOkHttp(isDebugMode: Boolean, apiKey: String): OkHttpClient {
        val logging = HttpLoggingInterceptor()

        if (isDebugMode) {
            logging.level =
                HttpLoggingInterceptor.Level.BODY
        } else logging.level = HttpLoggingInterceptor.Level.NONE

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .dns(Dns.SYSTEM)
            .connectTimeout(OK_HTTP_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(OK_HTTP_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(AuthorizationInterceptor(apiKey))
            .build()
    }

    private const val OK_HTTP_TIMEOUT = 60L
}

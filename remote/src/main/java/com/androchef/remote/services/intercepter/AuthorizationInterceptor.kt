package com.androchef.remote.services.intercepter

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException


class AuthorizationInterceptor(private val apiKey : String) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newHttpUrl = originalRequest.url().newBuilder()
            .addQueryParameter("api_key", apiKey).build()
        val newRequest = originalRequest.newBuilder().url(newHttpUrl).build()
        return chain.proceed(newRequest)
    }
}
package com.androidcenter.coroutinedemo

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.core.content.ContextCompat.getSystemService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.coroutines.coroutineContext


class RetrofitBuilder {

    companion object {
        private const val BASE_URL = "https://api.github.com/search/"
        private const val DEFAULT_TIMEOUT_IN_SEC = 60
        fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient().build())
                .build()
        }

        // Adding Logging Interceptor for api response
        private fun getOkHttpClient(): OkHttpClient.Builder {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val okHttpBuilder = OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT_IN_SEC.toLong(), TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT_IN_SEC.toLong(), TimeUnit.SECONDS)
            okHttpBuilder.addInterceptor(logging)

            return okHttpBuilder
        }

    }

}
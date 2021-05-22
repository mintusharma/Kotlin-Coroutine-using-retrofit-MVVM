package com.androidcenter.coroutinedemo

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("repositories")
    suspend fun getUsers(@Query("q")query:String):User
}
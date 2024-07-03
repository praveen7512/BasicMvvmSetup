package com.example.movietmdb.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).
            build()
    }

    val apiService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}


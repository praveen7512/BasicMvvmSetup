package com.example.movietmdb.data.network

import com.example.movietmdb.data.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("posts")
    suspend fun getPost() : List<Post>

    @GET("auth")
    suspend fun authDB() : Unit

    @POST("postComment")
    suspend fun loginAuth() : Unit




}
package com.example.movietmdb.data.repository

import com.example.movietmdb.data.model.Post
import com.example.movietmdb.data.network.ApiService
import com.example.movietmdb.data.network.RetrofitInstance
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostRepo @Inject constructor(private val apiService: ApiService) {

    suspend fun getPost(): Flow<List<Post>> = flow {

        emit(apiService.getPost())
    }

    suspend fun getAuth() = flow {
        emit(apiService.authDB())
    }

    suspend fun getLogin() = flow {
        emit(apiService.loginAuth())
    }
}


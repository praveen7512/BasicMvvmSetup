package com.example.movietmdb.di

import com.example.movietmdb.data.network.ApiService
import com.example.movietmdb.data.network.RetrofitInstance
import com.example.movietmdb.data.repository.PostRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideApiService() : ApiService {
        return RetrofitInstance.apiService
    }

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        return RetrofitInstance.retrofit
    }

    @Provides
    @Singleton
    fun provideRepo(apiService: ApiService) : PostRepo {
        return PostRepo(apiService)
    }
}


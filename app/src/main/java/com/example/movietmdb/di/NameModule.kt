package com.example.movietmdb.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NameModule {

    @Singleton
    @Provides
    @Named("baseurl")
    fun provideBaseUrl() : String {
        return "Base Url"
    }

    @Singleton
    @Provides
    @Named("kunal")
    fun provideNames() : String {
        return "kunal kushwaha"
    }
}


package com.example.movietmdb.data.repository

import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Named

class DatabaseRepo @Inject constructor( @Named("db") private val dbRepo: String) {


    fun dbInstance()  = flow<String> {
        emit(dbRepo)
    }
}
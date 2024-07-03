package com.example.movietmdb.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Named

class NameRepo @Inject  constructor(@Named("kunal") private val baseUrl : String) {


    fun getName() : Flow<String> = flow {
        emit(baseUrl)
    }

}
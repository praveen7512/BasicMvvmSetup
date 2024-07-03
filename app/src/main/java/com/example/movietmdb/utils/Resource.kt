package com.example.movietmdb.utils

sealed  class Resource<out T> {
    data class  Success<out T>(val data : T) : Resource<T>()
    data class  Error<out T>(val data : T) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}









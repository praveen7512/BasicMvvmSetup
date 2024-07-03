package com.example.movietmdb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movietmdb.data.repository.DatabaseRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DatabaseViewModel @Inject constructor(private val databaseRepo: DatabaseRepo) : ViewModel() {

    private val _dbRepo = MutableStateFlow<String>("")
    val dpRepo =  _dbRepo


    init {
        viewModelScope.launch {
            databaseRepo.dbInstance().collect{
                _dbRepo.value = it
            }
        }
    }

}
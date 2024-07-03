package com.example.movietmdb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movietmdb.data.repository.NameRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StringViewModel @Inject constructor (private val nameRepo : NameRepo) : ViewModel() {

    private val _nameString = MutableStateFlow<String>("")
    val nameString = _nameString

    init {
        viewModelScope.launch {
            nameRepo.getName().collect{
                _nameString.value = it
            }
        }
    }
}
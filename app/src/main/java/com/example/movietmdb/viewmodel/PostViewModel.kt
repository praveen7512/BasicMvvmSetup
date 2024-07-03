package com.example.movietmdb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movietmdb.data.model.Post
import com.example.movietmdb.data.repository.PostRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class  PostViewModel @Inject constructor (private val postRepo : PostRepo) :ViewModel() {

    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts = _posts

    init {
        viewModelScope.launch {
            postRepo.getPost().collect{
                _posts.value = it
            }
        }
    }
}



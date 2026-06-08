package com.example.labwork29

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.labwork29.data.Comment
import com.example.labwork29.data.Post
import com.example.labwork29.data.PostApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {
    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    private val _comments = MutableStateFlow<List<Comment>>(emptyList())
    val posts: StateFlow<List<Post>> = _posts
    val comment: StateFlow<List<Comment>> = _comments

    init {
        loadPosts()
    }

    private fun loadPosts(){
        viewModelScope.launch {
            try {
                _posts.value = PostApiService.api.getPosts()
            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                loadPosts()
            }
        }
    }

    fun loadComments(id: Int){
        viewModelScope.launch {
            try {
                _comments.value = PostApiService.api.getComments(id)
            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                loadComments(id)
            }
        }
    }

    fun addProduct(id: Int, username: String, title: String, body: String){
        viewModelScope.launch {
            try {
                PostApiService.api.createPost(Post(id, username, title, body))
                loadPosts()
            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                loadPosts()
            }
        }
    }

    fun deleteProduct(id: Int){
        viewModelScope.launch {
            try {
                PostApiService.api.deletePost(id)
                loadPosts()
            }catch (e: Exception){
                e.printStackTrace()
            } finally {
                loadPosts()
            }
        }
    }
}
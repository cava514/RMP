package com.example.labwork29.data

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

private const val BASE_URL = "https://forumapi.snowowl.ru"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface PostApi {
    @GET("/posts")
    suspend fun getPosts(): List<Post>

    @POST("/posts")
    suspend fun createPost(@Body post: Post): Post

    @PUT("/posts/{id}")
    suspend fun updatePost(@Path("id") id: Int, @Body post: Post): Post

    @DELETE("/posts/{id}")
    suspend fun deletePost(@Path("id") id: Int): Response<Unit>

    @GET("(/posts/{postId}/comments")
    suspend fun getComments(@Path("postId") id: Int): List<Comment>
}

object PostApiService{
    val api: PostApi by lazy {
        retrofit.create(PostApi::class.java)
    }
}
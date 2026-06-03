package com.example.apiapplication.data

import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

private const val BASE_URL = "http://192.168.4.151:5235"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface ProductApi {
    @GET("/products")
    suspend fun getProducts(): List<Product>

    @POST("/products")
    suspend fun createProduct(@Body product: Product): Product

    @PUT("/products/{id}")
    suspend fun updateProduct(@Path("id") id: Int, @Body product: Product): Product

    @DELETE("/products/{id}")
    suspend fun deleteProduct(@Path("id") id: Int): Response<Unit>
}

object ProductApiService{
    val api: ProductApi by lazy {
        retrofit.create(ProductApi::class.java)
    }
}
package com.example.labwork28.data

import java.time.Year

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val yearOfPublication: Int,
    val countPages: Int
)
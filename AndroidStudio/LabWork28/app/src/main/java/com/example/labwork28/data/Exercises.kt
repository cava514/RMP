package com.example.labwork28.data

data class Exercises(
    val id: Int,
    val title: String,
    val category: String,
    val duration: Int,
    val calories: Categories
)

enum class Categories(categories: String){
    CARDIO("кардио"),
    POWER_EQUIPMENT("силовое")
}
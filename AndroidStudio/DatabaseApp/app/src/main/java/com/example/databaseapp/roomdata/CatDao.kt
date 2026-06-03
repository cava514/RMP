package com.example.databaseapp.roomdata

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CatDao {
    @Query("SELECT * FROM cats")
    fun getCats(): LiveData<List<Cat>>

    @Query("SELECT * FROM cats WHERE cat_id = :id")
    fun getCatById(id: Int): Cat

    @Insert
    fun addCat(cat: Cat)

    @Delete
    fun deleteCat(cat: Cat)

    @Update
    fun updateCat(cat: Cat)
}
package com.example.databaseapp.roomdata

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cats")
class Cat {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo("cat_id")
    var id: Int = 0
    @ColumnInfo("cat_name")
    var name: String = ""

    constructor(){}

    constructor(id: Int, name: String){
        this.id = id
        this.name = name
    }

    constructor(name: String){
        this.name = name
    }
}
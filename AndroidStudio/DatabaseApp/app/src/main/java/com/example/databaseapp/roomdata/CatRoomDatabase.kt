package com.example.databaseapp.roomdata

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(Cat::class)], version = 1)
abstract class CatRoomDatabase: RoomDatabase() {

    abstract fun CatDao(): CatDao

    companion object{
        private var INSTANCE : CatRoomDatabase? = null

        fun getInstance(context: Context): CatRoomDatabase{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CatRoomDatabase::class.java,
                        "cat_db"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}
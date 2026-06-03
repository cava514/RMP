package com.example.databaseapp.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.compose.runtime.mutableStateOf
import kotlin.math.log

class DbHelper(context: Context)
    : SQLiteOpenHelper(context, "users_db", null, 1) {

    companion object{
        const val TABLE_USERS = "users"
        const val COLUMN_ID = "id"
        const val COLUMN_LOGIN = "login"
        const val COLUMN_PASSWORD = "password"
    }


    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = """
            CREATE TABLE $TABLE_USERS (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_LOGIN TEXT NOT NULL,
                $COLUMN_PASSWORD TEXT NOT NULL
            )
        """.trimIndent()

        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        onCreate(db)
    }

    fun insertUser(login: String, password: String): Long {
        val db = writableDatabase

        val values = ContentValues().apply {
            put(COLUMN_LOGIN, login)
            put(COLUMN_PASSWORD, password)
        }

        return db.insert(TABLE_USERS, null, values)
    }

    fun getAllUsers():List<User>{
        val users = mutableListOf<User>()

        val db = readableDatabase

        val cursor = db.query(TABLE_USERS,
            null,
            null,
            null,
            null,
            null,
            null)

        //val cursor1 = db.rawQuery("SELECT * FROM $TABLE_USERS", null)

        with(cursor){
            while (moveToNext()){
                val id = getInt(getColumnIndexOrThrow(COLUMN_ID))
                val login = getString(getColumnIndexOrThrow(COLUMN_LOGIN))
                val password = getString(getColumnIndexOrThrow(COLUMN_PASSWORD))

                users.add(User(id, login, password))
            }
        }

        cursor.close()

        return users
    }

    fun deleteUser(id:Int): Int{
        val db = writableDatabase

        return db.delete(
            TABLE_USERS,
            "$COLUMN_ID = ?",
            arrayOf(id.toString())
        )
    }
}
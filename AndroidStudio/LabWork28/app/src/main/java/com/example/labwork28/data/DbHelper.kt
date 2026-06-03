package com.example.labwork28.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.time.Year
import kotlin.apply
import kotlin.text.trimIndent

class DbHelper(context: Context)
    : SQLiteOpenHelper(context, "books_db", null, 1) {

    companion object{
        const val TABLE_BOOKS = "books"
        const val COLUMN_ID = "id"
        const val COLUMN_TITLE = "title"
        const val COLUMN_AUTHOR = "author"
        const val COLUMN_YEAROFPUBLICATION = "yearOfPublication"
        const val COLUMN_COUNTPAGES = "countPages"
    }


    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = """
            CREATE TABLE $TABLE_BOOKS (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_TITLE TEXT NOT NULL,
                $COLUMN_AUTHOR TEXT NOT NULL,
                $COLUMN_YEAROFPUBLICATION INT NOT NULL,
                $COLUMN_COUNTPAGES INTEGER NOT NULL
            )
        """.trimIndent()

        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_BOOKS")
        onCreate(db)
    }

    fun insertBook(title: String, author: String, yearOfPublication: Int, countPages: Int): Long {
        val db = writableDatabase

        val values = ContentValues().apply {
            put(COLUMN_TITLE, title)
            put(COLUMN_AUTHOR, author)
            put(COLUMN_YEAROFPUBLICATION, yearOfPublication)
            put(COLUMN_COUNTPAGES, countPages)
        }

        return db.insert(TABLE_BOOKS, null, values)
    }

    fun getAllBooks():List<Book>{
        val books = mutableListOf<Book>()

        val db = readableDatabase

        val cursor = db.query(TABLE_BOOKS,
            null,
            null,
            null,
            null,
            null,
            null)

        //val cursor1 = db.rawQuery("SELECT * FROM $TABLE_BOOKS", null)

        with(cursor) {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(COLUMN_ID))
                val title = getString(getColumnIndexOrThrow(COLUMN_TITLE))
                val author = getString(getColumnIndexOrThrow(COLUMN_AUTHOR))
                val yearOfPublication = getInt(getColumnIndexOrThrow(COLUMN_YEAROFPUBLICATION))
                val countPages = getInt(getColumnIndexOrThrow(COLUMN_COUNTPAGES))
                books.add(Book(id, title, author, yearOfPublication, countPages))
            }
        }

        cursor.close()

        return books
    }

    fun deleteBook(id:Int): Int{
        val db = writableDatabase

        return db.delete(
            TABLE_BOOKS,
            "$COLUMN_ID = ?",
            arrayOf(id.toString())
        )
    }
}
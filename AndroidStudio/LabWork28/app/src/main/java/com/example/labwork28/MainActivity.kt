package com.example.labwork28

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.labwork28.data.DbHelper
import com.example.labwork28.ui.theme.LabWork28Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork28Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BooksScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BooksScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    val db = remember { DbHelper(context) }

    var books by remember {
        mutableStateOf(db.getAllBooks())
    }

    var title by remember { mutableStateOf("") }
    var author by remember { mutableStateOf("") }
    var yearOfPublication by remember { mutableStateOf(0) }
    var countPages by remember { mutableStateOf(0) }

    Column(modifier.fillMaxSize()){
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Название") }
        )
        OutlinedTextField(
            value = author,
            onValueChange = { author = it },
            label = { Text("Автор") }
        )
        OutlinedTextField(
            value = yearOfPublication.toString(),
            onValueChange = { yearOfPublication = it.toInt() },
            label = { Text("Логин") }
        )
        OutlinedTextField(
            value = countPages.toString(),
            onValueChange = { countPages = it.toInt() },
            label = { Text("Пароль") }
        )
        Button(onClick = {
            if (title.isNotBlank() && author.isNotBlank()){
                db.insertBook(title, author, yearOfPublication, countPages)

                books = db.getAllBooks()

                title = ""
                author = ""
                yearOfPublication = 0
                countPages = 0
            }
        }) {
            Text("Добавить")
        }

        LazyColumn {
            items(books){
                Row {
                    Text("${it.id} | ${it.title} | ${it.author} | ${it.yearOfPublication} | ${it.countPages}")
                    IconButton(onClick = {
                        db.deleteBook(it.id)
                    }) {
                        Icon(Icons.Default.Delete, "Удалить")
                        db.getAllBooks()
                    }
                }
            }
        }
    }
}
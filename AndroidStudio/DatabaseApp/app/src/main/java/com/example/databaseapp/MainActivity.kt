package com.example.databaseapp

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
import androidx.compose.ui.tooling.preview.Preview
import com.example.databaseapp.data.DbHelper
import com.example.databaseapp.data.User
import com.example.databaseapp.ui.theme.DatabaseAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DatabaseAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UsersScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun UsersScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    val db = remember { DbHelper(context) }

    var users by remember {
        mutableStateOf(db.getAllUsers())
    }

    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier.fillMaxSize()){
        OutlinedTextField(
            value = login,
            onValueChange = { login = it },
            label = { Text("Логин") }
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Пароль") }
        )
        Button(onClick = {
            if (login.isNotBlank() && password.isNotBlank()){
                db.insertUser(login, password)

                users = db.getAllUsers()

                login = ""
                password = ""
            }
        }) {
            Text("Добавить")
        }

        LazyColumn {
            items(users){
                Row {
                    Text("${it.id} | ${it.login} | ${it.password}")
                    IconButton(onClick = {
                        db.deleteUser(it.id)
                    }) {
                        Icon(Icons.Default.Delete, "Удалить")
                    }
                }
            }
        }
    }
}
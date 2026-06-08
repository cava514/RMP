package com.example.labwork29

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.labwork29.ui.theme.LabWork29Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork29Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier, vm: PostViewModel = viewModel()) {
    Column(
        modifier = modifier
    ){
        val listPosts by vm.posts.collectAsState()
        val listComments by vm.comment.collectAsState()
        var id by remember { mutableStateOf(0) }
        var username by remember { mutableStateOf("") }
        var title by remember { mutableStateOf("") }
        var body by remember { mutableStateOf("") }

        var idComment by remember { mutableStateOf(1) }

        val openDialog = remember { mutableStateOf(false) }

        OutlinedTextField(id.toString(), {id = it.toInt()})
        OutlinedTextField(username, {username = it})
        OutlinedTextField(title, {title = it})
        OutlinedTextField(body, {body = it})
        Button({vm.addProduct(id, username, title, body)}) {
            Text("Добавить")
        }
        LazyColumn() {
            items(listPosts){ p->
                Card() {
                    Column() {
                        Text("ip: ${p.id}")
                        Text("username: ${p.username}")
                        Text("title: ${p.title}")
                        Text("body: ${p.body}")
                        Box(contentAlignment = Alignment.BottomEnd){
                            IconButton({vm.deleteProduct(p.id)}){
                                Icon(Icons.Default.Delete, "Delete")
                            }
                        }
                        Box(contentAlignment = Alignment.BottomCenter){
                            Text("Комментарии", Modifier.clickable(onClick = {
                                openDialog.value = true
                            }))
                        }
                    }
                }
            }
        }
        if (openDialog.value) {
            AlertDialog(
                onDismissRequest = { openDialog.value = false},
                text = {
                    LazyColumn() {
                        items(listComments){ c ->
                            Card() {
                                Text("${c.username}")
                                Text("${c.body}")
                            }
                        }
                    }
                },
                confirmButton = {
                    Button({ openDialog.value = false }) {
                        Text("OK")
                    }
                }
            )
        }
    }
}
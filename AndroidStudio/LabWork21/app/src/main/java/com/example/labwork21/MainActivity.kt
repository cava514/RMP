package com.example.labwork21

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.labwork21.ui.theme.LabWork21Theme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork21Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //Authorization1(modifier = Modifier.padding(innerPadding))
                    //Authorization2(modifier = Modifier.padding(innerPadding))
                    WorkMemory(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Authorization1(modifier: Modifier = Modifier){
    val openDialog = remember { mutableStateOf(false) }
    var textLogin by remember { mutableStateOf("") }
    var textPassword by remember { mutableStateOf("") }
    Column(modifier = modifier) {
        TextField(textLogin,
            { textLogin = it },
            label = { Text("Логин") },
            placeholder = {Text("...") })
        TextField(textPassword,
            { textPassword = it },
            label = { Text("Пароль") },
            placeholder = {Text("...") })
        Button({ openDialog.value = true }) { Text("Авторизоваться") }
    }
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = "Приветствие") },
            text = { Text("Добро пожаловать, $textLogin") },
            confirmButton = {
                Button({ openDialog.value = false }) {
                    Text("OK", fontSize = 22.sp)
                }
            }
        )
    }
}

@Composable
fun Authorization2(modifier: Modifier = Modifier){
    val openDialog = remember { mutableStateOf(false) }
    var textLogin by remember { mutableStateOf("") }
    var textPassword by remember { mutableStateOf("") }
    Column(modifier = modifier) {
        TextField(textLogin,
            { textLogin = it },
            label = { Text("Логин") },
            placeholder = {Text("...") })
        TextField(textPassword,
            { textPassword = it },
            label = { Text("Пароль") },
            placeholder = {Text("...") })
        Button({ openDialog.value = true }) { Text("Авторизоваться") }
    }
    if (textLogin != "" && textPassword != "") {
        if (openDialog.value) {
            AlertDialog(
                onDismissRequest = { openDialog.value = false },
                title = { Text(text = "Приветствие") },
                text = { Text("Добро пожаловать, $textLogin") },
                confirmButton = {
                    Button({ openDialog.value = false }) {
                        Text("OK", fontSize = 22.sp)
                    }
                }
            )
        }
    }
    else{
        if (openDialog.value) {
            AlertDialog(
                onDismissRequest = { openDialog.value = false },
                title = { Text(text = "ОШИБКА") },
                text = { Text("Введенные данные не корректны!") },
                confirmButton = {
                    Button({ openDialog.value = false },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Green)) {
                        Text("OK", fontSize = 22.sp)
                    }
                },
                dismissButton = {
                    Button({ openDialog.value = false },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red)) {
                        Text("Отмена", fontSize = 22.sp)
                    }
                },
                containerColor = Color.Magenta,
                titleContentColor = Color.Blue,
                textContentColor = Color.Cyan
            )
        }
    }
}

@Composable
fun WorkMemory(modifier: Modifier = Modifier){
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    Column() {
        Text("${Random.nextInt(1023)} МБ")
        Button({}) {
            Text("Очистить кеш")
        }
        Button(onClick = {
            coroutineScope.launch {
                snackbarHostState.showSnackbar(message = "This is a Snackbar")
            }
        }) {
            Text(text = "Click me!")
        }
        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier.align(Alignment.BottomCenter as Alignment.Horizontal)
        )
    }

}
package com.example.labwork25

import android.os.Bundle
import android.os.Environment
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.unit.sp
import com.example.labwork25.ui.theme.LabWork25Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork25Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //ReadFilePreview(modifier = Modifier.padding(innerPadding))
                    //ReadByStringFilePreview(modifier = Modifier.padding(innerPadding))
                    WriteByStringFilePreview(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReadFilePreview(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val text = context.assets.open("eula.txt").bufferedReader().use{
        it.readText()
    }
    var checkEnabled = remember { mutableStateOf(false) }
    LabWork25Theme {
        Column() {
            Box(modifier = Modifier){
                Text(text,
                    modifier = Modifier,
                    fontSize = 5.sp,
                )
            }
            Row() {
                Checkbox(
                    checked = false,
                    onCheckedChange = { checkEnabled.value = !checkEnabled.value },
                    modifier = Modifier
                )
                Text("«Я прочитал условия лицензионного соглашения")
            }
            Button({}, enabled = checkEnabled.value) {
                Text("«Принять»")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReadByStringFilePreview(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val text: List<String> = context.assets.open("weak_passwords.txt").bufferedReader().use{
        it.readLines()
    }
    val login = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val checkedIsFile = remember { mutableStateOf(false) }
    val checkEnabled = remember { mutableStateOf(false) }
    LabWork25Theme {
        Column() {
            OutlinedTextField(
                value = login.value,
                onValueChange = { login.value = it },
                label = { Text("Логин") }
            )
            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text("Пароль") },
                isError = checkedIsFile.value
            )
            Button({
                text.forEach {
                    if (it.toString() == password.toString())
                       checkedIsFile.value = true
                }
            },
                enabled = !login.value.isNullOrEmpty() && !password.value.isNullOrEmpty()
            ) {
                Text("Зарегестрироваться")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WriteByStringFilePreview(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val text: List<String> = context.assets.open("weak_passwords.txt").bufferedReader().use{
        it.readLines()
    }
    var login = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }
    var checkedIsFile = remember { mutableStateOf(false) }
    var checkEnabled = remember { mutableStateOf(false) }
    LabWork25Theme {
        Column() {
            OutlinedTextField(
                value = login.value,
                onValueChange = { login.value = it },
                label = { Text("Название") }
            )
            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text("Содержимое") },
                isError = checkedIsFile.value
            )
            context.getExternalFilesDir("app_notes")?.let{Text(it.path)}
            Button({
                if (!login.value.isNullOrEmpty() && !password.value.isNullOrEmpty()){

                }
                else{

                }
            },
                enabled = !login.value.isNullOrEmpty() && !password.value.isNullOrEmpty()
            ) {
                Text("Сохранить")
            }
        }
    }
}
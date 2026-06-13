package com.example.labwork30

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.KeyboardType
import com.example.labwork30.ui.theme.LabWork30Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork30Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        GreetingCalculation(modifier = Modifier.padding(innerPadding))
                        GreetingAuthorization(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingCalculation(modifier: Modifier = Modifier) {
    var delimoe by remember { mutableStateOf(0.0) }
    val isError = remember { mutableStateOf(false) }
    var delitel by remember { mutableStateOf(0.0) }
    val isByError = remember { mutableStateOf("") }
    val chastnoe = remember { mutableStateOf(0.0) }
    Column(modifier = modifier) {
        OutlinedTextField(
            value = delimoe.toString(),
            onValueChange = {
                Log.w("Hello", "Enter the correct value")
                delimoe = it.toDouble()
                            },
            label = {Text("Делимое")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            isError = isError.value)

        Text(isByError.value)

        OutlinedTextField(
            value = delitel.toString(),
            onValueChange = {
                Log.w("Hello", "Enter the correct value")
                delitel = it.toDouble()
                            },
            label = {Text("Делитель")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            isError = isError.value)

        Text(isByError.value)

        Button({
            Log.d("Hello", "Calculating the quotient")
            try {
                chastnoe.value = delimoe / delitel;
            }
            catch (e: ArithmeticException){
                Log.e("Hello", "Calculation error")
                isError.value = true
                isByError.value = e.message.toString()
            }
        }) {
            Text("Вычислить")
        }
        Text(text = "Частное: ${chastnoe.value}")
    }
}

@Composable
fun GreetingAuthorization(modifier: Modifier = Modifier) {
    val userList : List<User> = remember { mutableStateListOf(
        User(1, "Cava", "123"),
        User(2, "Roman", "qwerty")
    ) }
    var login by remember { mutableStateOf("") }
    val isError1 = remember { mutableStateOf(false) }
    var password by remember { mutableStateOf("") }
    val isByError = remember { mutableStateOf("") }
    var isCorrect by remember { mutableStateOf("Not entered") }
    Column(modifier = modifier) {
        OutlinedTextField(
            value = login,
            onValueChange = {
                Log.w("Hello", "Login entry")
                login = it
            },
            label = {Text("Логин")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            isError = isError1.value,
            modifier = Modifier.testTag("insertLogin"))

        Text(isByError.value)

        OutlinedTextField(
            value = password,
            onValueChange = {
                Log.w("Hello", "Password entry")
                password = it
            },
            label = {Text("Пароль")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            isError = isError1.value,
            modifier = Modifier.testTag("insertPassword"))

        Text(isByError.value)

        Button({
            Log.d("Hello", "Data comparison")
            val user = userList.firstOrNull{it.login == login && it.password == password}
            if (user?.login == login && user?.password == password)
                isCorrect = "You are logged in"
            else
                isCorrect = "Invalid username or password"
        }, modifier = Modifier.testTag("buttonIsCorrect")) {
            Text("Вход")
        }
        Text(text = isCorrect, modifier = Modifier.testTag("isCorrectLoginAndPassword"))
    }
}

data class User(
    val id: Int,
    val login: String,
    val password: String
)
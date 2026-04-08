package com.example.labwork15.screens

import android.widget.RemoteViews
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Label
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.labwork15.ui.theme.LabWork15Theme

var current by remember { mutableStateOf("") }

@Preview(showBackground = true)
@Composable
fun PseudoNavApp() {
    LabWork15Theme() {
        Column(Modifier.fillMaxWidth()) {
            Menu()
            when(current){
                "authorization" -> Authorization()
                "registration" -> Registration()
                else -> ProfileUser()
            }
        }
    }
}

enum class Screens(val route: String){
    ATHORIZATION("authorization"),
    REGISTRATION("registration"),
    PROFILE("profile")
}

@Composable
fun Menu(modifier: Modifier = Modifier){
    Row(modifier){
        Button({current = Screens.ATHORIZATION.route}) {
            Text("Авторизация")
        }
        Button({current = Screens.REGISTRATION.route}) {
            Text("Регистрация")
        }
        Button({current = Screens.PROFILE.route}) {
            Text("Профиль")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Authorization(modifier: Modifier = Modifier){
    Column(modifier) {
        Text("Авторизация")
        TextField(value = "", onValueChange = {},
            label = { Text("Логин") })
        TextField(value = "", onValueChange = {},
            label = { Text("Пароль") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password))
        Row(modifier) {
            Button(onClick = {}) {
                Text("Войти")
            }
            Button(onClick = {}) {
                Text("Зарегестрироваться")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Registration(modifier: Modifier = Modifier){
    Column(modifier) {
        Text("Регистрация")
        TextField(value = "", onValueChange = {},
            label = { Text("Логин") })
        TextField(value = "", onValueChange = {},
            label = { Text("Пароль") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password))
        TextField(value = "", onValueChange = {},
            label = { Text("Подтвердите пароль") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password))
        TextField(value = "", onValueChange = {},
            label = { Text("Номер телефона") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone))
        TextField(value = "", onValueChange = {},
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email))
        TextField(value = "", onValueChange = {},
            label = { Text("Возраст") })
        Button(onClick = {}) {
            Text("OK")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileUser(modifier: Modifier = Modifier){
    Column(modifier) {
        Text("Профиль")
        Text("О себе")
        Row() {
            Button(onClick = {}) {
                Text("Назад")
            }
            Button(onClick = {}) {
                Text("Вперёд")
            }
        }
    }
}
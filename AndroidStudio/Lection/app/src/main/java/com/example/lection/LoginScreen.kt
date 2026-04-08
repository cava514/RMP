package com.example.lection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun LoginScreen(){
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoggedOn by remember { mutableStateOf(false) }

    if(isLoggedOn){
        AlertDialog({isLoggedOn = false},
            {
                Button({isLoggedOn = false}) {
                Text("Ок")
                }
            },
            text = {Text("Вы вошли как $login")})
    }

    Column(Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(login,
            {login = it},
            label = { Text("Логин") })
        OutlinedTextField(password,
            {password = it},
            label = { Text("Пароль") })
        Button({}) {
            Text("Войти")
        }
    }
}

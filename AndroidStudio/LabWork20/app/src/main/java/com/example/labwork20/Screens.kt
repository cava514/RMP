package com.example.labwork20

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

enum class Screens(val route: String){
    AUTHORIZATION("authorization"),
    REGISTRATION("registration"),
    LISTPRODUCT("listProduct"),
    PRODUCT("product")
}

@Composable
fun Authorization(onOk:() -> Unit, onRegistration:() -> Unit){
    var textLogin by remember { mutableStateOf("") }
    var textPassword by remember { mutableStateOf("") }
    Column() {
        TextField(textLogin,
            {},
            label = { Text("Логин") },
            placeholder = {Text("...") })
        TextField(textPassword,
            {},
            label = { Text("Пароль") },
            placeholder = {Text("...") })
        Button({onOk()}) { Text("OK") }
        Button({onRegistration()}) { Text("Регистрация") }
    }
}

@Composable
fun Registration(onOk:() -> Unit){
    var textLogin by remember { mutableStateOf("") }
    var textPassword by remember { mutableStateOf("") }
    Column() {
        TextField(textLogin,
            {},
            label = { Text("Логин") },
            placeholder = {Text("...") })
        TextField(textPassword,
            {},
            label = { Text("Пароль") },
            placeholder = {Text("...") })
        TextField(textPassword,
            {},
            label = { Text("Подтверждение пароля") },
            placeholder = {Text("...") })
        Button({onOk()}) { Text("OK") }
    }
}

@Composable
fun ListProduct(onProduct:() -> Unit){
    val listProduct = listOf("яблоко", "банан", "груша", "огурец", "арбуз", "апельсин", "помидор", "баклажан", "кабачок", "тыква")
    Column() {
        listProduct.forEach {
            Text(it.toString(), modifier = Modifier.clickable{
                onProduct()
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Product(){
    Column() {
        Text("Название: ")
        Text("Цена: ")
    }
}
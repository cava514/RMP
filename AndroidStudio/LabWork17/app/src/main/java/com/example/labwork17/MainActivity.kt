package com.example.labwork17

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Label
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.trace
import com.example.labwork17.ui.theme.LabWork17Theme
import org.intellij.lang.annotations.JdkConstants

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork17Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //Authorization(modifier = Modifier.padding(innerPadding))
                    //Registration(modifier = Modifier.padding(innerPadding))
                    //ScreenInputPIN_Code(modifier = Modifier.padding(innerPadding))
                    //Profile(modifier = Modifier.padding(innerPadding))
                    //Registration1(modifier = Modifier.padding(innerPadding))
                    SliderTextChange(modifier = Modifier.padding(innerPadding))
                    ScreenNotification(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Authorization(modifier: Modifier = Modifier){
    Column(modifier = Modifier.fillMaxSize()) {
        val login = remember { mutableStateOf("") }
        OutlinedTextField(value = login.value,
            onValueChange = { text -> login.value = text },
            label = { Text("Логин") },
            placeholder = { Text("Введите логин") },
            modifier = Modifier.fillMaxWidth())
        var password by remember { mutableStateOf(TextFieldValue("")) }
        TextField(value = password,
            onValueChange = { text -> password = text},
            label = { Text("Пароль") },
            placeholder = { Text("Введите пароль") },
            modifier = Modifier.fillMaxWidth())
        val text = remember { mutableStateOf("") }
        Button(onClick = { text.value = "${login.value}, вы авторизованы" }) { Text("Авторизоваться") }
        Text(text = text.value)
    }
}

@Preview(showBackground = true)
@Composable
fun Registration(modifier: Modifier = Modifier){
    Column(modifier = Modifier.fillMaxSize()) {
        val login = remember { mutableStateOf("") }
        TextField(value = login.value,
            onValueChange = { text -> login.value = text },
            label = { Text("Логин") },
            placeholder = { Text("Введите логин") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth())
        var password by remember { mutableStateOf(TextFieldValue("")) }
        TextField(value = password,
            onValueChange = { text -> password = text},
            label = { Text("Пароль") },
            placeholder = { Text("Введите пароль") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth())
        TextField(value = "",
            onValueChange = {},
            label = { Text("Подтверждение пароля") },
            placeholder = { Text("") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth())
        TextField(value = "",
            onValueChange = {},
            label = { Text("Номер телефона") },
            placeholder = { Text("") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth())
        TextField(value = "",
            onValueChange = {},
            label = { Text("Email") },
            placeholder = { Text("") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth())
        TextField(value = "",
            onValueChange = {},
            label = { Text("Возраст") },
            placeholder = { Text("") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth())
        TextField(value = "",
            onValueChange = {},
            label = { Text("Персональный сайт") },
            placeholder = { Text("") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri),
            modifier = Modifier.fillMaxWidth())
        TextField(value = "",
            onValueChange = {},
            label = { Text("Числовой код (числовой пароль)") },
            placeholder = { Text("") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth())
        Button(onClick = {}) { Text("Зарегистрироваться") }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenInputPIN_Code(modifier: Modifier = Modifier){
    Column(modifier = Modifier.fillMaxSize()) {
        var pin_code by remember { mutableStateOf("") }
        val pin_code_in_system by remember { mutableStateOf("1234") }
        TextField(value = pin_code,
            onValueChange = { pin_code = if(it.length > 4) pin_code else it },
            label = { Text("Числовой код (числовой пароль)") },
            placeholder = { Text("") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        var popitka = remember { mutableStateOf(3) }
        var text = remember { mutableStateOf("Осталось ${popitka.value} попытки") }
        Text(text.value)
        Button(onClick = {
            if (popitka.value == 0){
                text.value = "Пока"
            }
            if (pin_code != pin_code_in_system){
                popitka.value--
                text.value = "Осталось ${popitka.value} попытки"
            }
            else{
                text.value = "Верно"
            }
        }) { Text("Ввести") }
    }
}

@Preview(showBackground = true)
@Composable
fun Profile(modifier: Modifier = Modifier){
    Column() {
        var profile by remember { mutableStateOf("") }
        TextField(
            value = profile,
            onValueChange = { profile = if(it.length > 50) profile else it },
            label = { Text("О себе") },
            placeholder = { Text("") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Text("${50 - profile.length} символов оставшихся для ввода")
    }
}

@Preview(showBackground = true)
@Composable
fun Registration1(modifier: Modifier = Modifier){
    Column(modifier = Modifier.fillMaxSize()) {
        val login = remember { mutableStateOf("") }
        TextField(value = login.value,
            onValueChange = { text -> login.value = text },
            label = { Text("Логин") },
            placeholder = { Text("Введите логин") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth())
        var password by remember { mutableStateOf(TextFieldValue("")) }
        TextField(value = password,
            onValueChange = { text -> password = text},
            label = { Text("Пароль") },
            placeholder = { Text("Введите пароль") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth())
        TextField(value = "",
            onValueChange = {},
            label = { Text("Подтверждение пароля") },
            placeholder = { Text("") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth())
        var isChecked by remember { mutableStateOf(false) }
        Row() {
            Checkbox(checked = isChecked, onCheckedChange = { isChecked = !isChecked})
            Text("Я согласен на обработку своих персональных данных и принимаю условия Политики конфиденциальности и Пользовательского соглашения")
        }
        Button(onClick = {}, enabled = isChecked) { Text("Зарегистрироваться") }
        val languages = listOf("Russia", "Englesh", "German")
        var selected by remember { mutableStateOf(languages[0]) }
        languages.forEach{ language ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(selected == language,
                    {selected = language})
                Text(language)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SliderTextChange(modifier: Modifier = Modifier){
    Column() {
        var length by remember { mutableStateOf(16.0f) }
        Column(modifier = Modifier.padding(30.dp)) {
            Slider(
                length, { length = it },
                valueRange = 10f..30f, steps = 19
            )
            Text("${length.toInt()}", Modifier.fillMaxWidth(), fontSize = length.sp)
        }
        var length1 by remember { mutableStateOf(3.0f) }
        Column(modifier = Modifier.padding(30.dp)) {
            Slider(
                length1, { length1 = it },
                valueRange = 1f..9f, steps = 3
            )
            Text(when(length1){
                1.0f -> "${length1.toInt()} день"
                3.0f -> "${length1.toInt()} дня"
                5.0f,7.0f,8.0f -> "${length1.toInt()} дней"
                else -> "${length1.toInt()} дней" }, Modifier.fillMaxWidth())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenNotification(modifier: Modifier = Modifier){
    Switch(checked = true, onCheckedChange = null)
}
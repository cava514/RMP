package com.example.labwork14

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import com.example.labwork14.ui.theme.LabWork14Theme
import java.lang.ArithmeticException
import java.util.stream.Stream

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork14Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    var div = division(1.00, 2.00)
                    GetDivision(division = div, modifier = Modifier)
                }
            }
        }
    }
}

/**
 * Вывод текста с вашим именем
 * @param name Имя
 * @param modifier Модификация, по умолчанию
 * @author Android Studio
 * @since 1.0
 * @sample [Greeting]
 */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LabWork14Theme {
        Greeting("Android")
    }
}

/**
 * Деление
 * @param a Делитель
 * @param b Делимое
 * @return [a] / [b] Частное
 * @throws ArithmeticException Деление на 0
 * @author Михаил Фёдорович Степаненко Stepan@yandex
 * @since 1.0
 * @sample [division]
 */
fun division(a: Double, b: Double): Double{
    if (b == 0.0)
        throw ArithmeticException()
    return a / b
}

@Composable
fun GetDivision(division:Double, modifier: Modifier = Modifier){
    Text(
        text = division.toString(),
        modifier = modifier
    )
}

/**
 * Класс пользователь
 * @constructor Логин и пароль
 * @property login Логин
 * @property password Пароль
 * @author Михаил Фёдорович Степаненко Stepan@yandex
 * @since 1.0
 * @sample [User]
 */
data class User(val login: String, var password: String){
    /**
     * Совпадение пароля у объекта
     * @param [_password] Пароль
     * @return [_password] == [password] Действительность пароля
     */
    fun DoPassword(_password: String): Boolean {
        return _password == password
    }
}
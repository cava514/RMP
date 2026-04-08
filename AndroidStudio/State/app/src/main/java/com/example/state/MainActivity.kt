package com.example.state

import android.R.attr.value
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.state.ui.theme.StateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            var message by rememberSaveable {
                mutableStateOf("Привет Артем")
            }
            Column {
                TextField(value = message,
                    onValueChange = { message = it })
                Counter()
            }
        }
    }
}

/**
 * Счетчик **нажатий**
 *
 *
 */

@Composable
fun Counter(){
    var clicks by remember { mutableStateOf(0) }
    val onClickChanges = {values :Int -> clicks = value}

    Column() {
        Text(text = "${clicks}", fontSize = 30.sp)
        Increment(clicks, onClickChanges)
    }
}

/**
 * Инкремент
 *
 * @param clicks значение счетчика
 */
@Composable
fun Increment(clicks: Int, onClickChanges: (Int) -> Unit){
    Text(text = "+",
        modifier = Modifier
            .clickable(onClick = {
                onClickChanges(clicks + 1)
            })
    )
}

/**
 * @return сумма элементов
 *
 * @since 24.02.2026
 * @sample com.example.state.sumExample
 * @see com.example.state.sumExample
 */
fun sum(a:Int, b: Int) : Int{
    return a+b
}

fun sumExample(){
    val result = sum(1, 2)
    print(result)
}
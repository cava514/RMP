package com.example.indication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.indication.ui.theme.IndicationTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IndicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var progress by remember { mutableStateOf(0f) }

    LaunchedEffect(Unit) {
        while (progress < 1f){
            progress+=0.01f
            delay(100)
        }
    }
    Column(modifier = modifier){
        CircularProgressIndicator(
            progress = {progress},
            strokeWidth = 10.dp,
            trackColor = Color.Green,
            color = Color.Red,
            strokeCap = StrokeCap.Square,
            gapSize = 10.dp,
            modifier = Modifier.size(100.dp)
        )

        LinearProgressIndicator(
            progress = {progress},
            trackColor = Color.Green,
            color = Color.Red,
            strokeCap = StrokeCap.Square,
            gapSize = 10.dp,
            modifier = Modifier.size(400.dp, 50.dp)
        )

        var messages by remember { mutableStateOf(0) }

        LaunchedEffect(Unit) {
            delay(2000)
            messages+=3
        }

        BadgedBox(
            badge = {
                if (messages > 0){
                    Badge(){
                        Text("$messages")
                    }
                }
            }
        ) {
            FloatingActionButton({}) {
                Icon(Icons.Filled.Email,
                    "Email")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}
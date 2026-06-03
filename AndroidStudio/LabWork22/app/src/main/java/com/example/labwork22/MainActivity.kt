package com.example.labwork22

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.labwork22.ui.theme.LabWork22Theme
import kotlinx.coroutines.delay
import java.sql.Time
import java.util.Timer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork22Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //DownloadBehind10Sec(modifier = Modifier.padding(innerPadding))
                    //DownloadBehind100MillisecondWithRandom(modifier = Modifier.padding(innerPadding))
                    StartBehind1Min(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DownloadBehind10Sec(modifier: Modifier = Modifier) {
    LabWork22Theme {
        var progress by remember { mutableStateOf(0f) }
        var enable by remember { mutableStateOf(true) }
        LaunchedEffect(Unit) {
            while (enable){
                while (progress < 1f){
                    progress+=0.01f
                    delay(100)
                }
                progress = 0f
            }
        }
        Column(modifier = modifier) {
            Button({
                enable = true
            }) {
                Text("«Скачать»")
            }
            CircularProgressIndicator(
                progress = { progress },
                strokeWidth = 10.dp,
                strokeCap = StrokeCap.Square,
                modifier = Modifier.size(100.dp)
            )
            LinearProgressIndicator(
                progress = {progress},
                strokeCap = StrokeCap.Square,
                modifier = Modifier.size(400.dp, 50.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DownloadBehind100MillisecondWithRandom(modifier: Modifier = Modifier) {
    LabWork22Theme {
        var progress by remember { mutableStateOf(0f) }
        var enable by remember { mutableStateOf(true) }
        var randomChislo by remember { mutableStateOf(0) }
        LaunchedEffect(Unit) {
            while (progress < 1f){
                progress+=0.01f
                delay(100)
            }
            progress = 0f
        }
        Column(modifier = modifier) {
            Button({
                enable = true
            }) {
                Text("«Скачать»")
            }
            LinearProgressIndicator(
                progress = {progress},
                strokeCap = StrokeCap.Square,
                modifier = Modifier.size(400.dp, 50.dp)
            )
            Text("$progress%")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartBehind1Min(modifier: Modifier = Modifier) {
    LabWork22Theme {
        var progress by remember { mutableStateOf(1f) }
        var enable by remember { mutableStateOf(true) }
        var timer by remember { mutableStateOf(60) }
        var colorCircularProgressIndicator by remember { mutableStateOf(Color.Blue) }
        var strokeWidth by remember { mutableStateOf(10.dp) }
        LaunchedEffect(Unit) {
            while (enable){
                while (progress > 0f){
                    progress-=0.0166f
                    timer-=1
                    if (timer <= 60 && timer >= 30){
                        colorCircularProgressIndicator = Color.Green
                        strokeWidth = 9.dp
                    }
                    if (timer <= 29 && timer >= 10){
                        colorCircularProgressIndicator = Color.Yellow
                        strokeWidth = 6.dp
                    }
                    if (timer <= 9 && timer >= 0){
                        colorCircularProgressIndicator = Color.Red
                        strokeWidth = 3.dp
                    }
                    delay(1000)
                }
                progress = 1f
            }
        }
        Column(modifier = modifier) {
            Button({
                enable = true
            }) {
                Text("«Старт»")
            }
            Box(){
                CircularProgressIndicator(
                    progress = { progress },
                    strokeWidth = strokeWidth,
                    strokeCap = StrokeCap.Square,
                    color = colorCircularProgressIndicator,
                    modifier = Modifier.size(100.dp).align(Alignment.Center)
                )
                Box(modifier = Modifier.align(Alignment.Center)){
                    Text("$timer")
                }
            }
        }
    }
}
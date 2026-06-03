package com.example.labwork24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Animatable
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.labwork24.ui.theme.LabWork24Theme
import kotlinx.coroutines.coroutineScope

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork24Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ColorAnimationExample(modifier = Modifier.padding(innerPadding))
                    //OffsetAnimation(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ColorAnimationExample(modifier: Modifier = Modifier) {
    Column(modifier) {
        var isRed1 by remember { mutableStateOf(true) }
        val color1 by animateColorAsState(
            targetValue = if (isRed1) Color.Red else Color.Blue,
            animationSpec = tween(durationMillis = 3000)
        )

        Box(
            modifier = Modifier
                .size(200.dp)
                .background(color1)
                .clickable { isRed1 = !isRed1 }
        )

        var isRed2 by remember { mutableStateOf(true) }
        val color2 by animateColorAsState(
            targetValue = if (isRed2) Color.Red else Color.Blue,
            animationSpec = keyframes {
                durationMillis = 10000
                Color.Blue.at(500)
                Color.Green.at(1000)
            }
        )

        Box(
            modifier = Modifier
                .size(200.dp)
                .background(color2)
                .clickable { isRed2 = !isRed2 }
        )

        var isRed3 by remember { mutableStateOf(true) }
        val color3 by animateColorAsState(
            targetValue = if (isRed3) Color.Red else Color.Blue,
            animationSpec = repeatable(3, animation = tween(2000))
        )

        Box(
            modifier = Modifier
                .size(200.dp)
                .background(color3)
                .clickable { isRed3 = !isRed3 }
        )

        var scaled by remember { mutableStateOf(false) }
        val scaling by animateFloatAsState(
            targetValue = if (scaled) 1f else 0.5f,
            animationSpec = keyframes {
                durationMillis = 1000
                if (scaled) {
                    0.6f at 100
                    1.2f at 500
                    1f at 800
                }
            }
        )

        Image(
            painter=painterResource(R.mipmap.cat),
            contentDescription = "Cat",
            modifier = Modifier
                .size(200.dp)
                .graphicsLayer(scaleX = scaling, scaleY = scaling)
                .background(Color.Green)
                .clickable { scaled = !scaled }
        )

        var isRed4 by remember { mutableStateOf(true) }
        val color4 by animateColorAsState(
            targetValue = if (isRed4) Color.Red else Color.Blue,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 1),
                repeatMode = RepeatMode.Reverse
                )
        )

        Box(
            modifier = Modifier
                .size(200.dp)
                .background(color4)
                .clickable { isRed4 = !isRed4 }
        )
    }
}

@Composable
fun OffsetAnimation(modifier: Modifier = Modifier) {
    Column(modifier) {
        var isRed1 by remember { mutableStateOf(true) }
        val color = remember { Animatable(Color.Red) }
        LaunchedEffect(isRed1) {
            color.animateTo(if (isRed1) Color.Red else Color.Blue, animationSpec = tween(2000))
        }

        Box(
            Modifier
                .size(200.dp)
                .background(color.value)
                .clickable{ isRed1 = !isRed1 }
        )

        var scaled by remember { mutableStateOf(false) }
        val scaling by animateFloatAsState(
            targetValue = if (scaled) 1f else 0.5f,
            animationSpec = keyframes {
                durationMillis = 1000
                if (scaled) {
                    0.6f at 100
                    1.2f at 500
                    1f at 800
                }
            }
        )


        Box(
            Modifier
                .size(200.dp)
                .graphicsLayer(scaleX = scaling, scaleY = scaling)
                .background(Color.Green)
                .clickable { scaled = !scaled }
        )
    }
}
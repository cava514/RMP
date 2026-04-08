package com.example.animations

import android.os.Bundle
import android.view.animation.RotateAnimation
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.defaultDecayAnimationSpec
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.InfiniteAnimationPolicy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.animations.ui.theme.AnimationsTheme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.net.CookieStore
import kotlin.coroutines.coroutineContext
import kotlin.math.roundToInt
import kotlin.math.roundToLong

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(Modifier.padding(innerPadding)){
                        InfiniteAnimationExample()
                    }
                }
            }
        }
    }
}

@Composable
fun ColorAnimationExample(){
    var isRed by remember { mutableStateOf(true) }
    val color by animateColorAsState(
        targetValue = if (isRed) Color.Red else Color.Blue,
        animationSpec = tween(durationMillis = 1000)
    )

    Box(
        modifier = Modifier
            .size(200.dp)
            .background(color)
            .clickable{isRed=!isRed}
    )
}

@Composable
fun OffsetAnimationExample(){
    var moved by remember { mutableStateOf(false) }

    val offsetX by animateDpAsState(
        targetValue = if (moved) 200.dp else 0.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
    )

    Box(
        modifier = Modifier
            .size(offsetX)
            .offset(x = offsetX)
            .background(Color.Green)
            .clickable{moved=!moved}
    )
}

@Composable
fun RotateAnimationExample(){
    var rotated by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(
        targetValue = if (rotated) 360f else 0f,
        animationSpec = tween(durationMillis = 1000,
            easing = CubicBezierEasing(1f, 2f, 3f, 4f)
        )
    )
    Box(
        modifier = Modifier
            .size(200.dp)
            .graphicsLayer(rotationZ = rotation)
            .background(Color.Magenta)
            .clickable{rotated=!rotated}
    )
}

@Composable
fun ScaleKeyframesAnimation(){
    var scaled by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if (scaled) 1f else 0.5f,
        animationSpec = keyframes{
            durationMillis = 1000
            if (scaled){
                0.6f at 180
                1.2f at 500
                1f at 800
            }
        }
    )

    Box(
        modifier = Modifier
            .size(200.dp)
            .graphicsLayer(scaleX = scale, scaleY = scale)
            .background(Color.Magenta)
            .clickable{scaled=!scaled}
    )
}

@Composable
fun OffsetAnimatableExample(){
    val animatedOffset = remember {
        Animatable(
            Offset(0f, 0f),
            typeConverter = Offset.VectorConverter
        )
    }

    Box(
        Modifier.fillMaxSize().background(Color.LightGray).pointerInput(Unit){
            coroutineScope{
                while (true){
                    val offset = awaitPointerEventScope { awaitFirstDown().position }

                    launch {
                        animatedOffset.animateTo(
                            offset,
                            animationSpec = spring(stiffness = Spring.StiffnessLow)
                        )
                    }
                }
            }
        }
    ){
        Box(
            Modifier.offset{
                IntOffset(
                    animatedOffset.value.x.roundToInt(),
                    animatedOffset.value.y.roundToInt()
                )
            }
                .size(40.dp)
                .background(Color.Black)
        )
    }
}

@Composable
fun VisibilityAnimationExample(){
    var isVisible by remember { mutableStateOf(false) }

    Column() {
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(animationSpec = tween(500))
                    + slideInHorizontally(),
            exit = fadeOut(animationSpec = tween(500))
                    + shrinkHorizontally()
        ) {
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.Magenta)
            )
        }
        Button({isVisible = !isVisible}) {
            Text("Тадам!")
        }
    }
}

@Composable
fun TransitionAnimationExample(){
    var state by remember { mutableStateOf(false) }
    val transition = updateTransition(
        targetState = state
    )

    val size by transition.animateDp {
        if (it) 150.dp else 100.dp
    }

    val color by transition.animateColor() {
        if (it) Color.Red else Color.Green
    }

    Box(
        modifier = Modifier
            .size(size)
            .background(color)
            .clickable{state = !state}
    )
}

@Composable
fun InfiniteAnimationExample() {
    val infiniteTransition = rememberInfiniteTransition()

    val scale by infiniteTransition.animateFloat(
        initialValue = 3f,
        targetValue = 6f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        )
    )
    Box(Modifier.fillMaxSize()) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.Center)
                .graphicsLayer(scaleX = scale, scaleY = scale),
            tint = Color.Red)
    }
}
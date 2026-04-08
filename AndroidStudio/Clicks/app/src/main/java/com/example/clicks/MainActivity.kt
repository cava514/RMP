package com.example.clicks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.blue
import com.example.clicks.ui.theme.ClicksTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClicksTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(Modifier.padding(innerPadding)){
                        Content()
                        TransformContent()
                    }
                }
            }
        }
    }
}

@Composable
fun Content(){
    Text("Click",
        Modifier.clickable{

        }
    )

    var text by remember { mutableStateOf("") }

    Box(
        Modifier.size(200.dp)
            .background(Color.Blue)
            .pointerInput(Unit){
                detectTapGestures (
                    onTap = {text = "Tap"},
                    onDoubleTap = {text = "DoubleTap"},
                    onPress = {text = "Press"},
                    onLongPress = {text = "LongPress"}
                )
            }
    )

    Text(text, fontSize = 30.sp)

    var xoffset by remember { mutableStateOf(0f) }


    Box(
        Modifier.size(200.dp)
            .offset{ IntOffset(xoffset.roundToInt(), 0) }
            .background(Color.Blue)
            .draggable(
                orientation = Orientation.Horizontal,
                state = rememberDraggableState { d ->
                    xoffset += d
                }
            )
    )

    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }

    Box(
        Modifier.size(200.dp)
            .offset{ IntOffset(xoffset.roundToInt(), offsetY.roundToInt()) }
            .background(Color.Blue)
            .pointerInput(Unit){
                detectDragGestures { _,  d ->
                    offsetX += d.x
                    offsetY += d.y
                }
            }
    )
}

@Composable
fun TransformContent(){
    var scale by remember { mutableStateOf(1f) }
    var rotation by remember { mutableStateOf(0f) }
    var offset by remember { mutableStateOf(Offset.Zero) }
    val state = rememberTransformableState { s, o, r ->
        scale *= s
        rotation += r
        offset += o
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Box(
            Modifier.size(200.dp)
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale,
                    rotationZ = rotation,
                    translationX = offset.x,
                    translationY = offset.y)
                .background(Color.Blue)
                .transformable(state)
        )
    }
}
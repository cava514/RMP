package com.example.clicker34

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import com.example.clicker34.ui.theme.cthulhuTextStyle
import kotlinx.coroutines.delay
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

data class Particle(
    var x: Float,
    var y: Float,
    var alpha: Float = 1f,
    val angle: Float = Random.nextFloat() * 2 * PI.toFloat(),
    val speed: Float = Random.nextFloat() * 5 + 2,
    val letter: String = ('A'..'Z').random().toString()
){
    private val speedX = cos(angle) * speed
    private val speedY = sin(angle) * speed
    var lifetime: Float = 1f

    fun update(){
        x += speedX
        y += speedY
        alpha -= 0.2f
        lifetime -= 0.02f
    }
}

@Composable
fun ParticleAnimation(particles: MutableList<Particle>){
    var invalidate by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        while (true){
            delay(16L)
            particles.removeAll{
                it.update()
                it.lifetime <= 0
            }
            invalidate = !invalidate
        }
    }
    val textMeasure = rememberTextMeasurer()
    Canvas(Modifier.fillMaxSize()){
        invalidate.let {
            for (part in particles) {
                val text = textMeasure.measure(
                    part.letter,
                    cthulhuTextStyle
                )
                drawText(text,
                    color = Color(
                        0.38f,
                        0.96f,
                        0.86f,
                        part.alpha),
                    topLeft = Offset(part.x, part.y),
                    shadow = Shadow(Color.Black,
                        Offset(5f, 5f),
                        10f)
                )
            }
        }
    }
}
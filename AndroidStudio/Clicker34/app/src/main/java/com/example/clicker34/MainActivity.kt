package com.example.clicker34

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MovableContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.clicker34.ui.theme.Clicker34Theme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClickerGame()
        }
    }
}

@Composable
fun ClickerGame(vm: GameViewModel = viewModel()){
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState { 2 }
    val pages = mapOf(0 to Icons.Default.Home, 1 to Icons.Default.ShoppingCart)

    Clicker34Theme {
        Scaffold(Modifier.fillMaxSize(),
            topBar = {
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier
                            .statusBarsPadding()
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.primary)
                            .height(100.dp)
                    ) {
                        Text("Души, принесенные в жертву:",
                            textAlign = TextAlign.Center,
                            fontSize = 30.sp,
                            color = MaterialTheme.colorScheme.onPrimary)
                        Text(vm.score.toString().format("%.2f"),
                            textAlign = TextAlign.Center,
                            fontSize = 30.sp,
                            color = MaterialTheme.colorScheme.onPrimary)
                    }
                },
            bottomBar = {
                Row(modifier = Modifier
                    .statusBarsPadding()
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .height(100.dp)) {

                    pages.forEach { (page, icon) ->
                        Button({
                            coroutineScope.launch {
                                pagerState.scrollToPage(page)
                            }
                        }, modifier = Modifier.weight(1f).fillMaxHeight(),
                            shape = RectangleShape
                        ) {
                            Icon(icon,"")
                        }
                    }
                }
            }
        ) { padding ->
            Column(Modifier
                .padding(padding)
                .fillMaxSize()) {

                HorizontalPager(pagerState, Modifier.fillMaxHeight()) { page ->
                    when (page) {
                        0 -> ClickScreen(vm)
                        1 -> UpgradesScreen(vm)
                    }
                }
            }
        }
    }
}


@Composable
fun UpgradesScreen(vm: GameViewModel){
    Column(Modifier.fillMaxSize()) {
        vm.upgrades.forEach { (type, upgrade) ->
            Card(Modifier.fillMaxWidth().padding(10.dp).clickable{vm.onUpgrade(upgrade)}) {
                Text(upgrade.title, fontSize = 25.sp,
                    modifier = Modifier.padding(5.dp))
                Text("${upgrade.level} lv. Значение: ${upgrade.currentValue()}",
                    Modifier.padding(5.dp))
                Text("Стоимость: ${String.format("%.2f", upgrade.currentCost())}",
                    Modifier.padding(5.dp))
            }
        }
    }
}


@Composable
fun ClickScreen(vm: GameViewModel) {
    Box(modifier = Modifier.fillMaxSize()){
        val particles = remember { mutableStateListOf<Particle>() }
        var buttonPosition by remember {
            mutableStateOf(Offset.Zero)
        }

        var isPressed by remember { mutableStateOf(false) }
        val tabScale by animateFloatAsState(
            targetValue = if (isPressed) 0.95f else 1f,
            animationSpec = tween(10)
        )

        Box(
            Modifier
                .size(300.dp)
                .align(Alignment.Center)
                .clip(CircleShape)
                .onGloballyPositioned {
                    buttonPosition = it.positionInParent()
                }
                .pointerInput(Unit) {
                    coroutineScope {
                        while (true) {
                            awaitPointerEventScope {
                                val down = awaitFirstDown()
                                val clickPosition = down.position + buttonPosition
                                isPressed = true
                                vm.onClick()
                                repeat(5) {
                                    particles.add(
                                        Particle(
                                            clickPosition.x,
                                            clickPosition.y
                                        )
                                    )
                                }
                                down.consume()

                                val up = waitForUpOrCancellation()
                                if (up != null) {
                                    isPressed = false
                                }
                            }
                        }
                    }
                }
        ) {
            Image(
                painterResource(R.drawable.cthulhu_star),
                contentDescription = "Background",
                modifier = Modifier.fillMaxSize()
            )

            Image(
                painterResource(R.drawable.cthulhu),
                contentDescription = "Cthulhu",
                modifier = Modifier
                    .fillMaxSize(0.7f)
                    .align(Alignment.Center)
                    .graphicsLayer(scaleX = tabScale, scaleY = tabScale)
            )
        }
        ParticleAnimation(particles)
    }

}
package com.example.resources

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.Dimension
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.resources.ui.theme.ResourcesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ResourcesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(Modifier.padding(innerPadding)){
                        Text(stringResource(R.string.welcome),
                            fontSize = 28.sp,
                            modifier = Modifier
                                .width(dimensionResource(R.dimen.header_width))
                                .background(colorResource(R.color.teal_200))
                        )
                        Text(stringResource(R.string.message, "ИСПП-34,45"),
                            fontSize = 28.sp)
                        Button({}) {
                            Text(stringResource(R.string.send_button))
                        }
                        Text(
                            pluralStringResource(R.plurals.cats, 1, 1),
                            fontSize = 28.sp)
                        Text(
                            pluralStringResource(R.plurals.cats, 15, 15),
                            fontSize = 28.sp)

                        stringArrayResource(R.array.languages)

                        Image(bitmap = ImageBitmap.imageResource(R.drawable.image),
                            contentDescription = "котэ")

                        Image(imageVector = ImageVector.vectorResource(R.drawable.picture),
                            contentDescription = "Дом",
                            modifier = Modifier.size(200.dp)
                        )

                        Image(painterResource(R.drawable.ic_launcher_foreground),
                            "чел")

                        val russoFontFamily = FontFamily(
                            Font(R.font.russoone_regular,
                                FontWeight.Normal)
                        )

                        Text("Hello",
                            fontSize = 30.sp,
                            fontFamily = russoFontFamily)
                    }
                }
            }
        }
    }
}
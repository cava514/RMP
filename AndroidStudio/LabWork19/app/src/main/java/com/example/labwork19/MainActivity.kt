package com.example.labwork19

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.labwork19.ui.theme.LabWork19Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork19Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var apple: Product = Product(1, "Яблоко", 0.00, 0)
                    var banana: Product = Product(2, "Банан", 0.00, 0)
                    var productList = mutableListOf<Product>(apple, banana)
                    //ProductList1_3(productList, modifier = Modifier.padding(innerPadding))
                    //ProductList1_4(productList, modifier = Modifier.padding(innerPadding))
                    ProductList2(productList, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

class Product(_article: Int, _name: String, _price: Double, _picture: Int){
    var article: Int = _article
    var name: String = _name
    var price: Double = _price
    var picture: Int = _picture
}

@Composable
fun ProductList1_3(products: MutableList<Product>, modifier: Modifier = Modifier){
    Column(modifier) {
        Row() {
            Card() {
                Image(
                    bitmap = ImageBitmap.imageResource(R.drawable.apple),
                    contentDescription = ""
                )
            }
            Text(products[0].name)
        }
        Row() {
            Text(products[0].price.toString())
        }
    }
}

@Composable
fun ProductList1_4(products: MutableList<Product>, modifier: Modifier = Modifier){
    Column(modifier) {
        Card(modifier) {
            Image(
                ImageBitmap.imageResource(R.drawable.banana),
                contentDescription = ""
            )
            Text(products[1].name)
            Text(products[1].price.toString())
        }
    }
}

@Composable
fun ProductList2(products: MutableList<Product>, modifier: Modifier = Modifier){
    var productSelect by remember { mutableStateOf("") }
    LazyColumn(modifier) {
        item {
            Text(productSelect)
        }
        items(products){ product ->
            Card(modifier) {
                Image(
                    ImageBitmap.imageResource(R.drawable.oil),
                    contentDescription = ""
                )
                Text(product.toString())
            }
        }

    }
}
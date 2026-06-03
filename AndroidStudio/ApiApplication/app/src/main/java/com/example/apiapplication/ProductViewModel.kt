package com.example.apiapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiapplication.data.Product
import com.example.apiapplication.data.ProductApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {
    private val _products= MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    init {
        loadProducts()
    }

    private fun loadProducts(){
        viewModelScope.launch{
            try {
                _products.value = ProductApiService.api.getProducts()
            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                loadProducts()
            }
        }
    }

    fun addProduct(id: Int, name: String, price: Double){
        viewModelScope.launch {
            try {
                ProductApiService.api.createProduct(Product(id, name, price))
                loadProducts()
            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                loadProducts()
            }
        }
    }

    fun deleteProduct(id: Int){
        viewModelScope.launch {
            try {
                ProductApiService.api.deleteProduct(id)
                loadProducts()
            }catch (e: Exception){
                e.printStackTrace()
            } finally {
                loadProducts()
            }
        }
    }
}
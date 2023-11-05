package com.example.snacksquad

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.*


class SharedViewModel: ViewModel() {

    var item by mutableStateOf<FoodDetail?>(null)
        private set

    fun addItem(newItem: FoodDetail) {
        item = newItem
    }


}
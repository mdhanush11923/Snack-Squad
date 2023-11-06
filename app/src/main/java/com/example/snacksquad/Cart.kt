package com.example.snacksquad

sealed class Cart(
    var qty: Int,
    val foodItems: MutableList<FoodDetail>,
    val foodNames: MutableList<String>
) {
    object cart: Cart(0, mutableListOf<FoodDetail>(), mutableListOf<String>())

    fun AddToCart(item: FoodDetail) {
        if (item.name in foodNames) {
            val ind = foodNames.indexOf(item.name)
            cart.foodItems[ind].qty++
        } else {
            cart.qty++
            item.qty = 1
            cart.foodItems.add(item)
            cart.foodNames.add(item.name)
        }
    }

    fun RemoveFromCart(item: FoodDetail) {
        if (item.name in foodNames) {
            val ind = foodNames.indexOf(item.name)
            if (cart.foodItems[ind].qty == 1) {
                cart.foodItems.removeAt(ind)
                cart.foodNames.removeAt(ind)
                cart.qty--
            } else {
                cart.foodItems[ind].qty--
            }
        }
    }

    fun DeleteFromCart(item: FoodDetail) {
        val ind = foodNames.indexOf(item.name)
        cart.foodItems.removeAt(ind)
        cart.foodNames.removeAt(ind)
        cart.qty--
    }

    fun GetCartItems(): MutableList<FoodDetail> {
        return cart.foodItems
    }

    fun GetItemQty(foodName: String): Int {
        if (foodName in foodNames) {
            val ind = foodNames.indexOf(foodName)
            return foodItems[ind].qty
        }

        return 0
    }
}
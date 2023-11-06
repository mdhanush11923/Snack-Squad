package com.example.snacksquad

sealed class Cart(
    var qty: Int,
    var cal: Int,
    var total: Float,
    val foodItems: MutableList<FoodDetail>,
    val foodNames: MutableList<String>
) {
    object cart: Cart(0, 0, 0f, mutableListOf<FoodDetail>(), mutableListOf<String>())

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
        cal += item.cal
        total += item.price
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
        cal -= item.cal
        total -= item.price
        if (total < 0)
            total = 0f
    }

    fun DeleteFromCart(item: FoodDetail) {
        val ind = foodNames.indexOf(item.name)
        cal -= foodItems[ind].cal * foodItems[ind].qty
        total -= foodItems[ind].price * foodItems[ind].qty
        if (total < 0)
            total = 0f

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
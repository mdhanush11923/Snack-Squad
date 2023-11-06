package com.example.snacksquad

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import kotlin.random.Random

data class CategoryDetail(
    val title: String,
    val boxColor: Color,
    val subBoxColor: Color,
    val route: String = "menu"
)

data class FoodDetail(
    val name: String,
    val image: Int = R.drawable.circle,
    val desc: String = "",
    val price: Float = 200f,
    val cal: Int = 0,
    val rating: Float = 0f,
    var qty: Int = 0,
    val route: String = "tbd"
)

fun GetSnackOfTheDay(): FoodDetail {
    val foodList = GetFoodItems()
    val snack = foodList[3]//foodList[Random.nextInt(foodList.size)]

    return snack
}
fun GetFoodItems(): MutableList<FoodDetail> {
    val food = mutableListOf<FoodDetail>()
    food.add(FoodDetail(
        name = "Burger",
        price = 150f,
        cal = 500,
        rating = 4.3f,
        desc = "A burger, short for \"hamburger,\" is a popular and iconic fast-food dish consisting of a cooked ground meat patty, typically made from beef, but sometimes from other meats like chicken, turkey, or even plant-based ingredients for vegetarian or vegan options. The patty is usually seasoned and grilled, pan-fried, or broiled, and it is often served in a sliced and toasted bun. Burgers are commonly garnished with a variety of toppings, which can include lettuce, tomatoes, onions, cheese, pickles, condiments like ketchup and mayonnaise, and other ingredients based on personal preference. Burgers are a beloved comfort food and come in numerous variations, ranging from classic cheeseburgers to gourmet creations with unique flavor combinations."
    ))
    food.add(FoodDetail(
        name = "Pizza",
        price = 300f,
        cal = 700,
        rating = 4.5f,
        desc = "\n" +
                "Pizza is a popular and versatile Italian dish that has gained worldwide acclaim. It typically consists of a round, flatbread crust that is topped with a variety of ingredients and baked in an oven. The most common pizza toppings include tomato sauce, mozzarella cheese, and various combinations of meats, vegetables, and herbs. Pizza can be customized to suit individual tastes, making it a favorite food for many.\n" +
                "\n" +
                "The origins of pizza can be traced back to Naples, Italy, where the Margherita pizza, with its simple toppings of tomatoes, mozzarella cheese, and basil, is a famous classic. In addition to traditional pizza, there are various regional and international variations, such as New York-style pizza, Chicago deep-dish pizza, and innovative gourmet pizzas with unique flavor profiles.\n" +
                "\n" +
                "Pizza is widely available at pizzerias, restaurants, and as a frozen or take-and-bake option in grocery stores. It's a beloved food for casual dining, takeout, and delivery, and it has become a global symbol of comfort and convenience."
    ))
    food.add(FoodDetail(
        name = "Momo",
        price = 180f,
        cal = 300,
        rating = 4.9f,
        desc = "Momos are a popular type of dumpling originating from Tibet, but they are also widely consumed in the Himalayan regions of India, Nepal, Bhutan, and beyond. Momos consist of a thin, circular piece of dough that is typically filled with a mixture of ground meat, such as beef, chicken, or pork, or vegetables. The dough is folded and shaped into small, crescent-shaped dumplings and then steamed, fried, or occasionally boiled.\n" +
                "\n" +
                "These delicious dumplings are often served with a dipping sauce, which can vary in flavor and spiciness. In addition to traditional meat or vegetable fillings, there are various regional and modern variations of momos, including cheese momos, paneer momos (cottage cheese), and even sweet momos filled with ingredients like chocolate or fruits.\n" +
                "\n" +
                "Momos have gained popularity in many parts of the world and are enjoyed both as a street food snack and in restaurants. They are known for their unique taste and the different ways they can be prepared to suit various culinary preferences."
    ))
    food.add(FoodDetail(
        name = "Hot Dog",
        price = 220f,
        cal = 660,
        rating = 3.9f,
        desc = "\n" +
                "A hot dog is a popular and classic American fast-food item and street food. It typically consists of a cooked sausage, usually made from beef or a combination of beef and pork, served inside a sliced, partially steamed or grilled, soft bun. The sausage is usually seasoned and may come in various forms, such as frankfurters or wieners.\n" +
                "\n" +
                "Hot dogs can be customized with a variety of toppings and condiments to suit individual preferences. Common hot dog toppings include mustard, ketchup, onions, sauerkraut, pickles, relish, mayonnaise, cheese, chili, and more. Regional variations of hot dogs exist, with distinct ingredients and styles. For example, the \"Chicago-style\" hot dog features a poppy seed bun, yellow mustard, onions, pickle spears, tomato slices, sport peppers, and celery salt.\n" +
                "\n" +
                "Hot dogs are a convenient and portable food, making them a favorite choice at sporting events, cookouts, fairs, and food carts. They are known for their simple, yet satisfying, taste and are a beloved part of American culinary culture."
    ))
    food.add(FoodDetail(
        name = "Gingerbread",
        price = 120f,
        cal = 140,
        rating = 4.0f,
        desc = "Gingerbread refers to a type of sweet baked treat with a distinct flavor of ginger and a slightly spiced, warm, and aromatic taste. There are several forms of gingerbread, each with its own characteristics:\n" +
                "\n" +
                "Gingerbread Cookies: These are perhaps the most well-known type of gingerbread. Gingerbread cookie dough is typically rolled out and shaped using cookie cutters, often in the shape of people, animals, or holiday-themed figures. After baking, these cookies can be decorated with icing, candies, or other embellishments.\n" +
                "\n" +
                "Gingerbread Cake: This is a moist and flavorful cake made with ginger, molasses, and various spices. It's often served as a dessert, and it may be layered and frosted with cream cheese frosting or simply dusted with powdered sugar.\n" +
                "\n" +
                "Gingerbread Houses: Gingerbread dough can be used to construct intricate and decorative edible houses during the holiday season. The pieces are baked and then assembled using icing as a \"glue,\" and they are often adorned with candies, gumdrops, and other edible decorations.\n" +
                "\n" +
                "Gingerbread is particularly popular during the winter holiday season and is associated with Christmas traditions in many parts of the world. It has a long history and is loved for its warm, comforting taste and its role in festive celebrations."
    ))

    return food
}
package com.example.snacksquad

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    val ingr: String = ""
)

fun GetSnackOfTheDay(): FoodDetail {
    val foodList = GetFoodItems()
    val snack = foodList.elementAt(2)//foodList[Random.nextInt(foodList.size)]

    return snack
}


fun GetFoodItems(categoryTitle: String = ""): MutableList<FoodDetail> {
    val food = mutableListOf<FoodDetail>()
    food.add(FoodDetail(
        name = "Potato Chips",
        desc = "Thin, crispy potato slices seasoned with salt. A classic snack with a satisfying crunch.",
        cal = 152,
        ingr = "Potatoes, vegetable oil, salt",
        rating = 4.5f,
        price = 2.49f,
        image = R.drawable.__potatochips
    ))

    food.add(FoodDetail(
        name = "Popcorn",
        desc = "Popped corn kernels, light and fluffy, a guilt-free movie night favorite.",
        cal = 31,
        ingr = "Corn kernels, oil, salt",
        rating = 4.2f,
        price = 1.99f,
        image = R.drawable.__popcorn
    ))

    food.add(FoodDetail(
        name = "Chocolate Bar",
        desc = "Creamy milk chocolate or rich dark chocolate in a convenient bar form.",
        cal = 210,
        ingr = "Cocoa, sugar, milk, cocoa butter",
        rating = 4.6f,
        price = 1.29f,
        image = R.drawable.__chocolatebar
    ))

    food.add(FoodDetail(
        name = "Pretzels",
        desc = "Crunchy baked or twisted pretzel snacks with a hint of salt.",
        cal = 108,
        ingr = "Wheat flour, salt, yeast",
        rating = 4.0f,
        price = 1.99f,
        image = R.drawable.__pretzles
    ))


    food.add(FoodDetail(
        name = "Trail Mix",
        desc = "A mix of nuts, dried fruits, and sometimes chocolate, a perfect energy-boosting snack.",
        cal = 31,
        ingr = "Almonds, cashews, raisins, chocolate",
        rating = 4.4f,
        price = 3.99f,
        image = R.drawable.__trailmix
    )    )

    food.add(FoodDetail(
        name = "Nachos",
        desc = "Corn tortilla chips topped with melted cheese, jalapeños, and salsa.",
        cal = 140,
        ingr = "Corn chips, cheese, salsa",
        rating = 4.3f,
        price = 4.49f,
        image = R.drawable.__nachos
    ))

    food.add(FoodDetail(
        name = "Cheese Puffs",
        desc = "Light and airy cheese-flavored snacks with a satisfying crunch.",
        cal = 140,
        ingr = "Cornmeal, cheese flavoring",
        rating = 4.1f,
        price = 1.99f,
        image = R.drawable.__cheesepuffs
    ))

    food.add(FoodDetail(
        name = "Fruit Gummies",
        desc = "Chewy, fruity candies in various shapes and flavors.",
        cal = 100,
        ingr = "Sugar, gelatin, fruit flavors",
        rating = 4.5f,
        price = 1.49f,
        image = R.drawable.__fruitgummies
    ))


    food.add(FoodDetail(
        name = "Beef Jerky",
        desc = "Dried, seasoned strips of lean beef, a high-protein snack.",
        cal = 80,
        ingr = "Beef, seasonings",
        rating = 4.4f,
        price = 5.99f,
        image = R.drawable._0_beefjerky
    ))

    food.add(FoodDetail(
        name = "Granola Bar",
        desc = "A nutritious, chewy bar packed with oats, nuts, and dried fruits, perfect for a quick energy boost.",
        cal = 190,
        ingr = "Oats, honey, nuts, dried fruits",
        rating = 4.3f,
        price = 1.99f,
        image = R.drawable._1_granolabar
    ))

    food.add(FoodDetail(
        name = "Donuts",
        desc = "Sweet, fried dough with various toppings and fillings, a delightful treat for any time of day.",
        cal = 195,
        ingr = "Flour, sugar, yeast, icing",
        rating = 4.6f,
        price = 0.99f,
        image = R.drawable._2_donuts
    ))

    food.add(FoodDetail(
        name = "Caramel Popcorn",
        desc = "Popcorn coated with a sweet caramel glaze, offering a satisfying mix of salty and sweet flavors.",
        cal = 125,
        ingr = "Popcorn, caramel, butter",
        rating = 4.4f,
        price = 2.99f,
        image = R.drawable._3_caramelpopcorn
    ))

    food.add(FoodDetail(
        name = "Peanut Butter Cookies",
        desc = "Classic cookies with a rich, nutty flavor and a soft, chewy texture.",
        cal = 80,
        ingr = "Peanut butter, sugar, eggs, flour",
        rating = 4.5f,
        price = 3.49f,
        image = R.drawable._4_poeanutbuttercookies
    ))

    food.add(FoodDetail(
        name = "Fruit Snack Packs",
        desc = "Convenient packs of bite-sized fruit snacks made from real fruit juice.",
        cal = 80,
        ingr = "Fruit juice, gelatin, sugar",
        rating = 4.2f,
        price = 2.79f,
        image = R.drawable._5_fruitsnackpacks
    ))

    food.add(FoodDetail(
        name = "Mini Tacos",
        desc = "Bite-sized tacos filled with seasoned meat, cheese, and salsa, a delicious and savory snack.",
        cal = 125,
        ingr = "Mini tortillas, ground beef, cheese, salsa",
        rating = 4.3f,
        price = 4.99f,
        image = R.drawable._6_minitacos
    ))

    food.add(FoodDetail(
        name = "Chocolate Chip Cookies",
        desc = "Classic cookies with chocolate chips, offering a delightful blend of sweet and savory.",
        cal = 50,
        ingr = "Flour, sugar, chocolate chips",
        rating = 4.6f,
        price = 2.99f,
        image = R.drawable._7_chocolatechipcookies
    ))

    food.add(FoodDetail(
        name = "Brownies",
        desc = "Rich, fudgy, and decadent chocolate squares, a beloved dessert snack.",
        cal = 130,
        ingr = "Chocolate, butter, eggs, sugar",
        rating = 4.7f,
        price = 2.49f,
        image = R.drawable._8_brownies
    ))

    food.add(FoodDetail(
        name = "Mixed Nuts",
        desc = "A combination of roasted and salted nuts, offering a satisfying blend of flavors and textures.",
        cal = 170,
        ingr = "Almonds, cashews, peanuts",
        rating = 4.4f,
        price = 4.99f,
        image = R.drawable._9_mixednuts
    ))

    food.add(FoodDetail(
        name = "Fruit and Nut Bars",
        desc = "Nutrient-rich bars made with dried fruits and nuts, a wholesome on-the-go option.",
        cal = 200,
        ingr = "Nuts, dried fruits, honey",
        rating = 4.5f,
        price = 1.99f,
        image = R.drawable._0_fruitandnutbar
    ))

    food.add(FoodDetail(
        name = "Mini Pizzas",
        desc = "Miniature pizza bites with savory toppings and melted cheese, perfect for snacking.",
        cal = 445,
        ingr = "Mini pizza crusts, sauce, cheese, toppings",
        rating = 4.2f,
        price = 3.99f,
        image = R.drawable._1_minipizzas
    ))

    food.add(FoodDetail(
        name = "Rice Krispies Treats",
        desc = "Sweet and chewy bars made from puffed rice cereal, marshmallows, and butter.",
        cal = 90,
        ingr = "Rice Krispies, marshmallows, butter",
        rating = 4.3f,
        price = 1.49f,
        image = R.drawable._2_ricekrispiestreats
    ))

    food.add(FoodDetail(
        name = "Cheese and Crackers",
        desc = "A classic combination of cheese slices or spreads with crisp crackers.",
        cal = 336,
        ingr = "Cheese, crackers",
        rating = 4.0f,
        price = 2.99f,
        image = R.drawable._3_cheeseandcrackers
    ))

    food.add(FoodDetail(
        name = "Veggie Sticks with Hummus",
        desc = "Fresh vegetable sticks (carrots, celery, and cucumber) paired with creamy hummus for a healthy snack.",
        cal = 122,
        ingr = "Carrots, celery, cucumber, hummus",
        rating = 4.4f,
        price = 3.49f,
        image = R.drawable._4_veggiestickswithhummus
    ))

    food.add(FoodDetail(
        name = "Chocolate Covered Pretzels",
        desc = "Salty pretzels coated with a layer of sweet chocolate, a delightful blend of flavors.",
        cal = 450,
        ingr = "Pretzels, chocolate coating",
        rating = 4.5f,
        price = 2.99f,
        image = R.drawable._5_chocolatecoveredpretzels
    ))

    food.add(FoodDetail(
        name = "Mozzarella Sticks",
        desc = "Crispy breaded mozzarella cheese sticks with a gooey, melted center, perfect for dipping.",
        cal = 300,
        ingr = "Mozzarella cheese, breading, oil",
        rating = 4.6f,
        price = 4.99f,
        image = R.drawable._6_mozzarellasticks
    ))

    food.add(FoodDetail(
        name = "Sliced Apples with Caramel",
        desc = "Fresh apple slices served with a side of rich caramel sauce, a tasty and satisfying snack.",
        cal = 125,
        ingr = "Apples, caramel sauce",
        rating = 4.2f,
        price = 2.49f,
        image = R.drawable._7_slicedapplescaramel
    ))

    food.add(FoodDetail(
        name = "Pita Chips with Hummus",
        desc = "Crunchy pita chips paired with creamy hummus, a tasty and nutritious combination.",
        cal = 139,
        ingr = "Pita chips, hummus",
        rating = 4.1f,
        price = 3.29f,
        image = R.drawable._8_pitachips
    ))

    food.add(FoodDetail(
        name = "Chocolate-Covered Strawberries",
        desc = "Fresh, juicy strawberries coated in rich, smooth chocolate, a romantic treat or dessert.",
        cal = 200,
        ingr = "Strawberries, chocolate",
        rating = 4.7f,
        price = 5.49f,
        image = R.drawable._9_chocolatestrawberry
    ))

    food.add(FoodDetail(
        name = "Cucumber Slices with Dip",
        desc = "Refreshing cucumber slices paired with a tangy yogurt or ranch dip, a healthy and hydrating snack.",
        cal = 49,
        ingr = "Cucumbers, dip",
        rating = 4.0f,
        price = 2.49f,
        image = R.drawable._0_cucumberslices
    ))

    food.add(FoodDetail(
        name = "Muffins",
        desc = "Soft and moist baked goods in various flavors, perfect for breakfast or a quick snack.",
        cal = 80,
        ingr = "Flour, sugar, eggs, flavorings",
        rating = 4.3f,
        price = 2.99f,
        image = R.drawable._1_muffins
    ))

    food.add(FoodDetail(
        name = "Gummy Bears",
        desc = "Chewy, fruity gummy candies in the shape of bears, a favorite among both kids and adults.",
        cal = 140,
        ingr = "Sugar, gelatin, fruit flavors",
        rating = 4.4f,
        price = 1.29f,
        image = R.drawable._2_gummybears
    ))

    food.add(FoodDetail(
        name = "Soft Pretzels",
        desc = "Warm and doughy pretzels, often sprinkled with salt, ideal for dipping in cheese or mustard.",
        cal = 178,
        ingr = "Flour, water, salt",
        rating = 4.5f,
        price = 2.79f,
        image = R.drawable._3_softpretzels
    ))

    food.add(FoodDetail(
        name = "Veggie Chips",
        desc = "Crispy chips made from various vegetables, a healthier alternative to traditional potato chips.",
        cal = 130,
        ingr = "Vegetable slices, oil, salt",
        rating = 4.2f,
        price = 3.49f,
        image = R.drawable._4_veggiechips
    ))

    food.add(FoodDetail(
        name = "S'mores",
        desc = "A campfire classic, featuring marshmallows and chocolate sandwiched between graham crackers.",
        cal = 222,
        ingr = "Marshmallows, chocolate, graham crackers",
        rating = 4.6f,
        price = 2.99f,
        image = R.drawable._5_smores
    ))

    food.add(FoodDetail(
        name = "Chocolate-Covered Nuts",
        desc = "Nuts like almonds or peanuts coated in a layer of delicious chocolate.",
        cal = 210,
        ingr = "Nuts, chocolate coating",
        rating = 4.3f,
        price = 4.29f,
        image = R.drawable._6_chocolatenuts
    ))

    food.add(FoodDetail(
        name = "Cinnamon Rolls",
        desc = "Sweet and fluffy rolls swirled with cinnamon, often topped with icing.",
        cal = 227,
        ingr = "Dough, cinnamon, sugar, icing",
        rating = 4.4f,
        price = 3.49f,
        image = R.drawable._7_cinnamonrolls
    ))

    food.add(FoodDetail(
        name = "Chocolate Milkshake",
        desc = "A thick and creamy blend of milk and chocolate ice cream, a cool and indulgent beverage.",
        cal = 365,
        ingr = "Milk, chocolate ice cream",
        rating = 4.7f,
        price = 3.99f,
        image = R.drawable._8_chocolatemilkshake
    ))

    food.add(FoodDetail(
        name = "Popsicles",
        desc = "Frozen, fruity treats on a stick, perfect for a refreshing cool-down on hot days.",
        cal = 48,
        ingr = "Fruit juice, sugar",
        rating = 4.2f,
        price = 1.49f,
        image = R.drawable._9_popsicles
    ))

    food.add(FoodDetail(
        name = "Buffalo Chicken Wings",
        desc = "Spicy, tangy chicken wings served with a side of ranch or blue cheese dressing.",
        cal = 643,
        ingr = "Chicken wings, hot sauce, butter",
        rating = 4.5f,
        price = 6.99f,
        image = R.drawable._0_buffalochickenwings
    ))

    food.add(FoodDetail(
        name = "Churros",
        desc = "Long, fried dough pastries dusted with sugar and cinnamon, a delightful sweet treat.",
        cal = 237,
        ingr = "Flour, sugar, cinnamon",
        rating = 4.4f,
        price = 2.49f,
        image = R.drawable._1_churros
    ))

    food.add(FoodDetail(
        name = "Mini Corn Dogs",
        desc = "Bite-sized hot dogs coated in cornmeal batter, perfect for dipping in ketchup or mustard.",
        cal = 200,
        ingr = "Mini hot dogs, cornmeal batter",
        rating = 4.2f,
        price = 4.29f,
        image = R.drawable._2_minicorndogs
    ))

    food.add(FoodDetail(
        name = "Guacamole and Tortilla Chips",
        desc = "Creamy avocado dip with tortilla chips for a classic and flavorful snack.",
        cal = 289,
        ingr = "Avocado, spices, tortilla chips",
        rating = 4.6f,
        price = 3.49f,
        image = R.drawable._3_guacamoletortillachips
    ))

    food.add(FoodDetail(
        name = "Oatmeal Cookies",
        desc = "Soft and chewy cookies with oats, often with raisins or chocolate chips.",
        cal = 80,
        ingr = "Oats, sugar, raisins or chocolate chips",
        rating = 4.3f,
        price = 2.99f,
        image = R.drawable._4_oatmealcookies
    ))

    food.add(FoodDetail(
        name = "Quesadillas",
        desc = "Tortillas filled with cheese, sometimes with added meats or vegetables, a savory snack or meal.",
        cal = 445,
        ingr = "Tortillas, cheese, fillings",
        rating = 4.5f,
        price = 4.99f,
        image = R.drawable._5_quesadillas
    ))

    food.add(FoodDetail(
        name = "Mixed Berries",
        desc = "A medley of fresh or frozen berries like strawberries, blueberries, and raspberries, a healthy and tasty snack.",
        cal = 131,
        ingr = "Mixed berries",
        rating = 4.4f,
        price = 2.99f,
        image = R.drawable._6_mixedberries
    ))

    food.add(FoodDetail(
        name = "Cheddar Cheese Cubes",
        desc = "Bite-sized cubes of sharp cheddar cheese, a satisfying and savory snack.",
        cal = 666,
        ingr = "Cheddar cheese",
        rating = 4.2f,
        price = 3.29f,
        image = R.drawable._7_cheddarcheesecubes
    ))

    food.add(FoodDetail(
        name = "Caramel Apples",
        desc = "Apples coated with a layer of rich caramel, a sweet and crunchy delight.",
        cal = 215,
        ingr = "Apples, caramel",
        rating = 4.5f,
        price = 2.99f,
        image = R.drawable._8_caramelapples
    ))

    food.add(FoodDetail(
        name = "Mini Quiches",
        desc = "Miniature savory pastry tarts filled with eggs, cheese, and various ingredients.",
        cal = 178,
        ingr = "Pastry, eggs, cheese, fillings",
        rating = 4.3f,
        price = 4.49f,
        image = R.drawable._9_miniquiches
    ))

    food.add(FoodDetail(
        name = "Biscuits and Gravy",
        desc = "Soft biscuits smothered in creamy sausage gravy, a hearty Southern-style snack or breakfast.",
        cal = 380,
        ingr = "Biscuits, sausage gravy",
        rating = 4.4f,
        price = 3.99f,
        image = R.drawable._0_biscuitsandgravy
    ))

    food.add(FoodDetail(
        name = "Cheetos",
        desc = "Crunchy, cheesy snacks with a unique orange color and a bold, savory flavor.",
        cal = 150,
        ingr = "Cornmeal, cheese flavoring",
        rating = 4.3f,
        price = 1.99f,
        image = R.drawable._1_cheetos
    ))

    food.add(FoodDetail(
        name = "Jelly Beans",
        desc = "Small, sweet, and colorful bean-shaped candies with a variety of fruity flavors.",
        cal = 140,
        ingr = "Sugar, gelatin, fruit flavors",
        rating = 4.4f,
        price = 1.49f,
        image = R.drawable._2_jellybeans
    ))

    if (categoryTitle == "Popular")
        return food.subList(10,25)
    else if (categoryTitle == "Favorites")
        return food.subList(26,40)
    else
        return food

}
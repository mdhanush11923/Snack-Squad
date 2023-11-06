package com.example.snacksquad

sealed class User(
    var firstName: String = "",
    var lastName: String = "",
    var emailId: String = "",
    var password: String = "",
    var city: String = "",
    var street: String = "",
    var floor: String = "",
    var dietPref: Boolean = false
) {
    object user: User()

    fun FillPersonalInfo(fname: String, lname: String, email: String, pass: String) {
        user.firstName = fname
        user.lastName = lname
        user.emailId = email
        user.password = pass
    }

    fun FillAddress(city: String, street: String, floor: String) {
        user.city = city
        user.street = street
        user.floor = floor
    }
}
package com.example.drinkjournal

import android.media.Rating

data class DrinkData(
    var drinkName: String,
    var drinkMaker: String,
    var drinkType: String,
    var drinkOrigin: String,
    var drinkAlcoholPercentage: Short,
    var drinkRating: Rating,
    var drinkDescription: String
)

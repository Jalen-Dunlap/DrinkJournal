package com.example.drinkjournal

import android.media.Rating

abstract class DrinkData() {
    constructor(
        drinkName: String,
        drinkMaker: String,
        drinkType: String,
        drinkOrigin: String,
        drinkAlcoholPercentage: Short,
        drinkRating: Rating,
        drinkDescription: String
    ) : this()
}
package com.example.drinkjournal

import android.media.Rating

class WineData(
    name: String,
    wineType: String,
    maker: String,
    origin: String,
    alcoholPercent: Short,
    rating: Rating,
    description: String
) {
    var wineStyle = wineType
    var drinkData = DrinkData(name,maker,"Wine",origin,alcoholPercent,rating,description)
}

package com.drinkjournal.drinkjournal

import android.media.Rating

class MixedData (
    name: String,
    mixedType: String,
    mixedMixer: String,
    maker: String,
    origin: String,
    alcoholPercent: Short,
    rating: Rating,
    description: String
) {
    var mixedStyle = mixedType
    var mixedMixer = mixedMixer
    var drinkData = DrinkData(name,maker,"Wine",origin,alcoholPercent,rating,description)
}

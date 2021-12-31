package com.drinkjournal.dataClasses

import android.media.Rating

class BeerData( name: String,
                beerType: String,
                maker: String,
                origin: String,
                alcoholPercent: Short,
                rating: Rating,
                description: String
                ){
    var beerStyle = beerType
    var drinkData = DrinkData(name,maker,"Beer",origin,alcoholPercent,rating,description)
}
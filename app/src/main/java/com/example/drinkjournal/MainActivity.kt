package com.example.drinkjournal

import android.media.Rating
import android.media.Rating.RATING_5_STARS
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun testBeer(){
        var beerData = BeerData("Alaskan IPA","IPA","Alaskan",
                            "Juneau, AK",7, Rating.newStarRating(RATING_5_STARS,4.2f),
                        "Fruity with a full body")
        println(beerData.beerStyle)
    }

}

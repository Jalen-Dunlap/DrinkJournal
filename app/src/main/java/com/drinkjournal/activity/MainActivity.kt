package com.drinkjournal.activity

import android.content.Intent
import android.media.Rating
import android.media.Rating.RATING_5_STARS
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.drinkjournal.dataClasses.BeerData
import com.example.drinkjournal.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toNewDrink()

        toMyJournal()

        toSettings()
    }

    fun testBeer(){
        var beerData = BeerData("Alaskan IPA","IPA","Alaskan",
                            "Juneau, AK",7, Rating.newStarRating(RATING_5_STARS,4.2f),
                        "Fruity with a full body")
        println(beerData.beerStyle)
    }

    fun toNewDrink(){
        val newDrink = findViewById<Button>(R.id.newDrinkButton)
        newDrink.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, NewDrinkActivity::class.java))
        })
    }

    fun toMyJournal(){
        val myJournal = findViewById<Button>(R.id.myJournalButton)
        myJournal.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,MyJournalActivity::class.java))
        })
    }

    fun toSettings(){
        val settingsButton = findViewById<Button>(R.id.settingsButton)
        settingsButton.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        })
    }
}

package com.drinkjournal.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import com.drinkjournal.dataClasses.DrinkData
import com.drinkjournal.drinkjournal.R
import com.drinkjournal.managers.DBHelper

class DrinkView : AppCompatActivity(){
    private lateinit var name: String
    private lateinit var type: String
    private lateinit var specs : String
    private var alcoholPercentage = -1
    private lateinit var maker: String
    private lateinit var origin: String
    private lateinit var description: String
    private var rating = 0.0f
    private var id = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_view)

        if (intent.extras != null){
            id = intent.getIntExtra("id",-1)
            name = intent.getStringExtra("name").toString()
            type = intent.getStringExtra("type").toString()
            specs = intent.getStringExtra("specs").toString()
            alcoholPercentage = intent.getIntExtra("alcPercent",-1)
            maker = intent.getStringExtra("maker").toString()
            origin = intent.getStringExtra("origin").toString()
            description = intent.getStringExtra("description").toString()
            rating = intent.getFloatExtra("rating",3.5f)
        }

        if (rating > 5){
            rating = 5.0f
        }
        var drink = DrinkData(name,type,specs,alcoholPercentage,maker,origin,description,rating)
        drink.drinkId = id

        displayDrink()

        backButton()

        //updateDrink()

        deleteDrink(drink)
    }

    private fun displayDrink() {
        val etName = findViewById<EditText>(R.id.drinkNameDrinkView)
        val etType = findViewById<EditText>(R.id.drinkTypeDrinkView)
        val etSpecs = findViewById<EditText>(R.id.drinkSpecsDrinkView)
        val etAlcPercent = findViewById<EditText>(R.id.alcoholPercentDrinkView)
        val etMaker = findViewById<EditText>(R.id.drinkMakerDrinkView)
        val etOrigin = findViewById<EditText>(R.id.drinkOriginDrinkView)
        val etDescription = findViewById<EditText>(R.id.drinkDescriptionDrinkView)
        val etRating = findViewById<RatingBar>(R.id.ratingBarDrinkView)

        etName.setText(name)
        etType.setText(type)
        etSpecs.setText(specs)
        etAlcPercent.setText(alcoholPercentage.toString())
        etMaker.setText(maker)
        etOrigin.setText(origin)
        etDescription.setText(description)
        etRating.numStars = 5
        etRating.rating = rating
    }

    private fun backButton(){
        val backButton = findViewById<Button>(R.id.backButtonDrinkView)
        backButton.setOnClickListener{
            finish()
        }
    }

    private fun deleteDrink(drinkToDelete:DrinkData) {
        val myJournalDB = DBHelper(this)
        val deleteButton = findViewById<Button>(R.id.deleteDrink)
        deleteButton.setOnClickListener {
            val status = myJournalDB.deleteDrink(drinkToDelete)
            if (status>-1){
                finish()
            }else{
                toastMessage("Unable to delete")
            }
        }
    }

    private fun updateDrink(){
        //TODO
        /*
        * Take id in db
        * update data in db
        */
    }

    private fun toastMessage(message :String){
        Toast.makeText(applicationContext,message, Toast.LENGTH_SHORT).show()
    }
}
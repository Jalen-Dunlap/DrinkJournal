package com.drinkjournal.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import com.drinkjournal.drinkjournal.R

class DrinkView : AppCompatActivity(){
    private lateinit var name: String
    private lateinit var type: String
    private lateinit var specs : String
    private lateinit var alcoholPercentageString: String
    private lateinit var maker: String
    private lateinit var origin: String
    private lateinit var description: String
    private var rating = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_view)

        if (intent.extras != null){
            name = intent.getStringExtra("name").toString()
            type = intent.getStringExtra("type").toString()
            specs = intent.getStringExtra("specs").toString()
            alcoholPercentageString = intent.getStringExtra("alcPercent").toString()
            maker = intent.getStringExtra("maker").toString()
            origin = intent.getStringExtra("origin").toString()
            description = intent.getStringExtra("description").toString()
            rating = intent.getFloatExtra("rating",3.5f)
        }

        if (rating > 5){
            rating = 5.0f
        }

        displayDrink()

        backButton()

        //updateDrink()

        //deleteDrink()
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
        etAlcPercent.setText(alcoholPercentageString)
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

    private fun deleteDrink() {
        //TODO
        /*
        * take id from db
        * delete from db table
        */
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
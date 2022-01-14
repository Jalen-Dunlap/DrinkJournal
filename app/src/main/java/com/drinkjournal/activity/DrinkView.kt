package com.drinkjournal.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import com.drinkjournal.drinkjournal.R

class DrinkView : AppCompatActivity(){
    lateinit var name: String
    lateinit var type: String
    lateinit var specs : String
    lateinit var alcoholPercentageString: String
    lateinit var maker: String
    lateinit var origin: String
    lateinit var description: String
    lateinit var ratingString: String
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
            ratingString = intent.getStringExtra("rating").toString()
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
        etRating.rating = ratingString.toFloat()
    }

    private fun backButton(){
        val backButton = findViewById<Button>(R.id.backButtonDrinkView)
        backButton.setOnClickListener{
            finish()
        }
    }

    private fun deleteDrink() {
        TODO("Not yet implemented")
    }

    private fun updateDrink(){
        // TODO: 12/31/2021
    }

    private fun toastMessage(message :String){
        Toast.makeText(applicationContext,message, Toast.LENGTH_SHORT).show()
    }
}
package com.drinkjournal.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import com.drinkjournal.dataClasses.DrinkData
import com.drinkjournal.db.DBHelper
import com.drinkjournal.drinkjournal.R

class NewDrinkActivity : AppCompatActivity(){

    private val myJournalDB = DBHelper(this)
    private lateinit var newDrink: DrinkData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_drink)

        addDrinkButton()

        backButton()
    }
    
    private fun addDrinkButton(){
        val addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener{
            val name = findViewById<EditText>(R.id.drinkName).text.toString()
            val type = findViewById<EditText>(R.id.drinkType).text.toString()
            val specs = findViewById<EditText>(R.id.drinkSpecs).text.toString()
            val alcoholPercent = findViewById<EditText>(R.id.alcoholPercent).text.toString().toInt()
            val maker = findViewById<EditText>(R.id.drinkMaker).text.toString()
            val origin = findViewById<EditText>(R.id.drinkOrigin).text.toString()
            val description = findViewById<EditText>(R.id.drinkDescription).text.toString()
            val rating = findViewById<RatingBar>(R.id.ratingBar).rating
        
            newDrink = DrinkData(name,type,specs,alcoholPercent,maker,origin,description,rating)

            // TODO: 1/10/2022 Create null exception for adding to DB

            val drinkSuccess = myJournalDB.addDrink(newDrink)

            if (drinkSuccess > -1){
                toastMessage("Added new drink to the journal")
                finish()
            }else{
                toastMessage("Failed to add new Drink")
            }
        }
    }

    private fun backButton(){
        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener{
            finish()
        }
    }

    private fun toastMessage(message :String){
        Toast.makeText(applicationContext,message, Toast.LENGTH_SHORT).show()
    }
}

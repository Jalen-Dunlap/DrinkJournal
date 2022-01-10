package com.drinkjournal.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import com.drinkjournal.dataClasses.DrinkData
import com.drinkjournal.db.DBHelper
import com.drinkjournal.drinkjournal.R
import java.lang.Exception
import java.lang.NumberFormatException
import kotlin.math.roundToInt

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
            var alcoholPercent = 0
            val name = findViewById<EditText>(R.id.drinkName).text.toString()
            val type = findViewById<EditText>(R.id.drinkType).text.toString()
            val specs = findViewById<EditText>(R.id.drinkSpecs).text.toString()
            val alcoholPercentString = findViewById<EditText>(R.id.alcoholPercent).text.toString()
            val maker = findViewById<EditText>(R.id.drinkMaker).text.toString()
            val origin = findViewById<EditText>(R.id.drinkOrigin).text.toString()
            val description = findViewById<EditText>(R.id.drinkDescription).text.toString()
            val rating = findViewById<RatingBar>(R.id.ratingBar).rating

            try {
                alcoholPercent = alcoholPercentString.toFloat().toInt()
            }catch (e: NumberFormatException){
                Log.d("CATCH","Caught numberformat exception")
                toastMessage("Alcohol Percentage needs to be fixed")
            }catch (e: Exception){
            }

            Log.d("MyActivity","DEBUG :::::::name:$name \n a%:$alcoholPercent \n rat:$rating")
            if (name != "" && type != "" && specs != "" && alcoholPercent >= 0
                && maker != "" && origin != "" && description != "" && rating >= 0) {
                newDrink =
                    DrinkData(name, type, specs, alcoholPercent, maker, origin, description, rating)

                val drinkSuccess = myJournalDB.addDrink(newDrink)

                if (drinkSuccess > -1) {
                    toastMessage("Added new drink to the journal")
                    finish()
                } else {
                    toastMessage("Failed to add new Drink")
                }
            }else{
                toastMessage("You need to fill in all of the fields for the drink")
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

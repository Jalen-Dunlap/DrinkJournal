package com.drinkjournal.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.drinkjournal.dataClasses.DrinkData
import com.drinkjournal.drinkjournal.R
import com.drinkjournal.managers.DBHelper
import com.drinkjournal.managers.MyListAdapter

class MyJournalActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_journal)

        backButton()
        displayDrinks()
    }

    override fun onResume() {
        super.onResume()
    }


    private fun displayDrinks(){
        val myJournalListView = findViewById<ListView>(R.id.myJournalList)
        val myJournalDB = DBHelper(this)

        val drinks: List<DrinkData> = myJournalDB.viewDrinks()
        val drinksArrayName = Array<String>(drinks.size){"0"}
        val drinksArrayType = Array<String>(drinks.size){"null"}

        for ((index, drink) in drinks.withIndex()){
            drinksArrayName[index] = drink.drinkName
            drinksArrayType[index] = drink.drinkType
        }

        val myListAdapter = MyListAdapter(this,drinksArrayName,drinksArrayType)
        myJournalListView.adapter = myListAdapter

        myJournalListView.setOnItemClickListener { _, _, position, _ ->
            Log.d("Delete","----------Clicked item")
            val intent = Intent(this,DrinkView::class.java)
            val drink = drinks[position]
            Log.d("Delete","----------Created intent and drink")

            intent.putExtra("id",drink.drinkId)
            intent.putExtra("name",drink.drinkName)
            intent.putExtra("type",drink.drinkType)
            intent.putExtra("specs",drink.drinkSpecifics)
            intent.putExtra("alcPercent",drink.drinkAlcoholPercentage)
            intent.putExtra("maker",drink.drinkMaker)
            intent.putExtra("origin",drink.drinkOrigin)
            intent.putExtra("description",drink.drinkDescription)
            intent.putExtra("rating",drink.drinkRating)
            Log.d("Delete","----------added intent extras")

            startActivity(intent)
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
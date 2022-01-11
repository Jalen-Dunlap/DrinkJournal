package com.drinkjournal.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
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
        viewDrink()
    }

    private fun viewDrink(){
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
    }

    private fun backButton(){
        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener{
            Intent(this,MainActivity::class.java)
            finish()
        }
    }
}
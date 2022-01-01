package com.drinkjournal.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.drinkjournal.`interface`.IControls
import com.example.drinkjournal.R

class MyJournalActivity : AppCompatActivity(), IControls {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_journal)
    }

    fun viewDrink(){
        // TODO: 12/31/2021 show the drink selected
    }

    fun displayDrinks(){
        // TODO: 12/31/2021 Show the drinks in the journal on the page
    }
}
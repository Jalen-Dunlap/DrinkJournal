package com.drinkjournal.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.drinkjournal.R

class MyJournalActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_journal)

        backButton()
    }

    fun viewDrink(){
        // TODO: 12/31/2021 show the drink selected
    }

    fun displayDrinks(){
        // TODO: 12/31/2021 Show the drinks in the journal on the page
    }

    fun backButton(){
        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener(View.OnClickListener {
            Intent(this,MainActivity::class.java)
            finish()
        })
    }
}
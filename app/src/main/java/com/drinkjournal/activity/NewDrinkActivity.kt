package com.drinkjournal.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.drinkjournal.`interface`.IControls
import com.example.drinkjournal.R

class NewDrinkActivity : AppCompatActivity(), IControls {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_drink)

        addDrink()

        discardDrink()
    }
    
    private fun addDrink(){
        val addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext,"Added new drink to the journal", Toast.LENGTH_SHORT).show()
            Intent(this,MainActivity::class.java)
            finish()
        })
    }
    
    private fun discardDrink(){
        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener(View.OnClickListener {
            Intent(this,MainActivity::class.java)
            finish()
        })
    }
}

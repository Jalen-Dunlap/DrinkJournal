package com.drinkjournal.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.drinkjournal.db.DBHelper
import com.drinkjournal.drinkjournal.R

class MainActivity : AppCompatActivity() {

    var myJournalDB = DBHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toNewDrink()

        toMyJournal()

        toSettings()
    }

    private fun toNewDrink(){
        val newDrink = findViewById<Button>(R.id.newDrinkButton)
        newDrink.setOnClickListener {
            View.OnClickListener {
                startActivity(Intent(this, NewDrinkActivity::class.java))
            }
        }

    }

    private fun toMyJournal(){
        val myJournal = findViewById<Button>(R.id.myJournalButton)
        myJournal.setOnClickListener{View.OnClickListener {
            startActivity(
                Intent(
                    this,
                    MyJournalActivity::class.java
                )
            )
        }}
    }

    private fun toSettings(){
        val settingsButton = findViewById<Button>(R.id.settingsButton)
        settingsButton.setOnClickListener{
            View.OnClickListener {
                Toast.makeText(applicationContext,"Not currently available", Toast.LENGTH_SHORT).show()
                //startActivity(Intent(this, SettingsActivity::class.java))
            }
        }
    }
}

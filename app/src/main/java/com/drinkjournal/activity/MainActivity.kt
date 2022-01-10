package com.drinkjournal.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.drinkjournal.db.DBHelper
import com.drinkjournal.drinkjournal.R

class MainActivity : AppCompatActivity() {

    var myJournalDB = DBHelper(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toNewDrink(view: View){
        startActivity(Intent(this, NewDrinkActivity::class.java))
    }

    fun toMyJournal(view: View){
        startActivity(Intent(this,MyJournalActivity::class.java))
    }

    fun toSettings(view: View){
        Toast.makeText(applicationContext,"Not currently available", Toast.LENGTH_SHORT).show()
    }
}


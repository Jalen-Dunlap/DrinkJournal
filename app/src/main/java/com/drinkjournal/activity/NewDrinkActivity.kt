package com.drinkjournal.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.drinkjournal.`interface`.IControls
import com.example.drinkjournal.R

class NewDrinkActivity : AppCompatActivity(), IControls {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_drink)
    }
}
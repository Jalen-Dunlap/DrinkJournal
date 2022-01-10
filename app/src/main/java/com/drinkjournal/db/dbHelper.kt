package com.drinkjournal.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.drinkjournal.dataClasses.DrinkData

class DBHelper(context: Context) : SQLiteOpenHelper(context,TABLE_NAME,null,DATABASE_VERSION) {

    companion object{
        private const val TABLE_NAME = "MyJournal"
        private const val DATABASE_VERSION = 1
    }

    private val col0 = "ID"
    private val col1 = "name"
    private val col2 = "drinkType"
    private val col3 = "drinkSpecifics"
    private val col4 = "alcoholPercent"
    private val col5 = "drinkMaker"
    private val col6 = "drinkOrigin"
    private val col7 = "description"
    private val col8 = "rating"

    override fun onCreate(db: SQLiteDatabase?) {
        val createDrinkJournal = (
                "CREATE TABLE " + TABLE_NAME +
                col0 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                col1 + " TEXT," +
                col2 + " TEXT," +
                col3 + " TEXT," +
                col4 + " INTEGER," +
                col5 + " TEXT," +
                col6 + " TEXT," +
                col7 + " TEXT," +
                col8 + " REAL," + ")"
                )
        db?.execSQL(createDrinkJournal)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addDrink(drink: DrinkData): Long{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(col1,drink.drinkName)
        contentValues.put(col2,drink.drinkType)
        contentValues.put(col3,drink.drinkSpecifics)
        contentValues.put(col4,drink.drinkAlcoholPercentage)
        contentValues.put(col5,drink.drinkMaker)
        contentValues.put(col6,drink.drinkOrigin)
        contentValues.put(col7,drink.drinkDescription)
        contentValues.put(col8,drink.drinkRating)

        val success = db.insert(TABLE_NAME,null,contentValues)
        db.close()
        return success
    }
}
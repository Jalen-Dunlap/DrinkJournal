package com.drinkjournal.managers

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
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
                "CREATE TABLE " + TABLE_NAME + "(" +
                col0 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                col1 + " TEXT," +
                col2 + " TEXT," +
                col3 + " TEXT," +
                col4 + " INTEGER," +
                col5 + " TEXT," +
                col6 + " TEXT," +
                col7 + " TEXT," +
                col8 + " REAL" + ")"
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

    fun viewDrinks(): List<DrinkData> {
        val drinkList : ArrayList<DrinkData> = ArrayList<DrinkData>()
        val selectQuery = "SELECT * FROM $TABLE_NAME"
        val db = this.readableDatabase
        var cursor: Cursor? = null

        try {
            cursor = db.rawQuery(selectQuery, null)
        }catch (e: SQLiteException) {
            db.execSQL(selectQuery)
            return ArrayList()
        }

        var name: String
        var type: String
        var specs: String
        var alcoholPercent: Int
        var maker: String
        var origin: String
        var description: String
        var rating: Float

        if (cursor.moveToFirst()){
            do{
                name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
                type = cursor.getString(cursor.getColumnIndexOrThrow("drinkType"))
                specs =  cursor.getString(cursor.getColumnIndexOrThrow("drinkSpecifics"))
                alcoholPercent = cursor.getInt(cursor.getColumnIndexOrThrow("alcoholPercent"))
                maker = cursor.getString(cursor.getColumnIndexOrThrow("drinkMaker"))
                origin = cursor.getString(cursor.getColumnIndexOrThrow("drinkOrigin"))
                description = cursor.getString(cursor.getColumnIndexOrThrow("description"))
                rating = cursor.getFloat(cursor.getColumnIndexOrThrow("rating"))

                val drink = DrinkData(name, type,specs,alcoholPercent,maker,origin,description,rating)
                drinkList.add(drink)

            } while (cursor.moveToNext())

            cursor.close()
        }
        return drinkList
    }
}
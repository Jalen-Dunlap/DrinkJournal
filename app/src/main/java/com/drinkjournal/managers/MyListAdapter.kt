package com.drinkjournal.managers

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.drinkjournal.drinkjournal.R

class MyListAdapter(private val context: Activity,private val drinkName: Array<String>,private val drinkType: Array<String>) :
    ArrayAdapter<String>(context, R.layout.journal_list_layout, drinkName) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.journal_list_layout,null,true)

        val name = rowView.findViewById(R.id.tvName) as TextView
        val type = rowView.findViewById(R.id.tvType) as TextView

        name.text = "Name: ${(drinkName[position])}"
        type.text = "Type: ${(drinkType[position])}"

        return rowView
    }
}
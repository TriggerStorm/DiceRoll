package com.example.diceroll

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_history.*


class History : AppCompatActivity() {

    var rHistory = MainActivity.rollHistory

    var diceRoll: Array<ImageView?> = arrayOfNulls<ImageView>(5)

    val diceIds = arrayOf(R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        var sList = arrayListOf<String>()



        var listView = findViewById<ListView>(R.id.tvHisory)

        val prodAdapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, sList)

        listView.adapter = prodAdapter




        for (i in 0 until rHistory.size) {
            var s = ""
            var q = ""
            var currentRoll = rHistory[i]

            for (j in 0 until currentRoll.noOfDice.size)
            {
                if (currentRoll.noOfDice[j]!= null){
                s +=  "${currentRoll.noOfDice[j]?.plus(1)} "
                }
            }
            q += "${currentRoll.timestamp} "
            sList.add(q+s)
        }



    }



    fun onClickClear(view: View) {
        rHistory.clear()
        updateHistory()
    }
    fun updateHistory(){
        var sList = arrayListOf<String>()
        var listView = findViewById<ListView>(R.id.tvHisory)
        val prodAdapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, sList)
        listView.adapter = prodAdapter

    }
}

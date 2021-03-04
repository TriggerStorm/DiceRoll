package com.example.diceroll

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val mGenerator = Random()

    val diceIds = arrayOf(R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6)

    var nrDice = 1


    companion object{
        //val mHistory = mutableListOf<Pair<Int, Int>>()
        val rollHistory = mutableListOf<Roll>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.bnHistory);
        button.setOnClickListener{
            val intent = Intent(this, History::class.java)
            startActivity(intent)
        }
        numberPicker.minValue = 1
        numberPicker.maxValue = 6

        numberPicker.wrapSelectorWheel = true

        numberPicker.setOnValueChangedListener { numberPicker, oldValue, newValue -> nrDice = newValue }

        val gridLayout = findViewById<GridLayout>(R.id.grid)

        for (i in 0 until 6) {
            gridLayout.addView(ImageView(this), i)
        }

    }

    fun OnclickRoll(view: View) {
       // val d1 = mGenerator.nextInt(6)
       // val d2 = mGenerator.nextInt(6)
       // imgDice1.setImageResource(diceIds[d1])
      //  imgDice2.setImageResource(diceIds[d2])

        val roll = arrayOfNulls<Int>(6)
        for (i in 0 until nrDice) {
            val d1 = mGenerator.nextInt(6)
            roll[i]=d1
        }

        for (k in 0 until nrDice) {
            val v = grid.getChildAt(k) as ImageView
            v.setImageResource(diceIds[roll[k]!!])
        }

       // rollHistory.add((d1+1 , d2+1))
        //updateHistory(timestamp, roll)



    }

    private fun updateHistory() {
        var s = ""
       // rollHistory.forEach{ p -> val e1 = p.first; val e2 = p.second
         //                   s += "$e1 - $e2\n"
        //}


    }

    fun onClickClear(view: View) {
        //rollHistory.clear()
        //updateHistory()
    }

}
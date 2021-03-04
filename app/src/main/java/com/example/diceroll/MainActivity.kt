package com.example.diceroll

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.sql.Timestamp
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
        var time = Timestamp(System.currentTimeMillis())
        val roll = arrayOfNulls<Int>(6)
        for (i in 0 until nrDice) {
            val d1 = mGenerator.nextInt(6)
            roll[i]=d1
        }

        for (k in 0 until nrDice) {
            val v = grid.getChildAt(k) as ImageView
            v.setImageResource(diceIds[roll[k]!!])
        }
        val r = Roll(time , roll)

       // rollHistory.add((d1+1 , d2+1))
        updateHistory(r)



    }

    private fun updateHistory(roll: Roll) {

        rollHistory.add(roll)
    }

    fun onClickClear(view: View) {
        //rollHistory.clear()
        //updateHistory()
    }

}
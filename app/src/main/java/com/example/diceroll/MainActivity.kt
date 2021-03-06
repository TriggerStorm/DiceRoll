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
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    val mGenerator = Random()

    val diceIds = arrayOf(R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6)

    var nrDice = 1


    companion object{

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

        val yourmilliseconds = System.currentTimeMillis()
        val sdf = SimpleDateFormat("HH:mm:ss")
        val resultdate = Date(yourmilliseconds)
        val times =(sdf.format(resultdate))

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
        val r = Roll(times , roll)


        updateHistory(r)



    }

    private fun updateHistory(roll: Roll) {

        rollHistory.add(roll)
    }



}
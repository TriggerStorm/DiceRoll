package com.example.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val mGenerator = Random()

    val diceIds = arrayOf(R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6)

    val mHistory = mutableListOf<Pair<Int, Int>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun OnclickRoll(view: View) {
        val d1 = mGenerator.nextInt(6)
        val d2 = mGenerator.nextInt(6)

        imgDice1.setImageResource(diceIds[d1])
        imgDice2.setImageResource(diceIds[d2])

        if(mHistory.size >=5)
            mHistory.removeAt(0)
            mHistory.add(Pair(d1+1 , d2+1))
        updateHistory()



    }

    private fun updateHistory() {
        var s = ""
        mHistory.forEach{ p -> val e1 = p.first; val e2 = p.second
                            s += "$e1 - $e2\n"
        }
        tvHisory.text = s
    }

    fun onClickClear(view: View) {
        mHistory.clear()
        updateHistory()
    }
}
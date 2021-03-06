package com.example.diceroll

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_history.*

class History : AppCompatActivity() {

    //var mhistory = MainActivity.rollHistory
    var rHistory = MainActivity.rollHistory

    var diceRoll: Array<ImageView?> = arrayOfNulls<ImageView>(5)

    val diceIds = arrayOf(R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6)

    val timeArray: Array<String> = emptyArray()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        var s = ""
        var q = ""
       // rollHistory.forEach{ p -> val e1 = p.first; val e2 = p.second
         //   s += "$e1 - $e2\n"}
        //tvHisory.text = s

        /*for (int i = 0; i < mhistory.size; i++) {

            for (int x = )
            int res = getResources().getIdentifier("i"+i, "id", getPackageName());
            letters[i] = (ImageView) findViewById(res);*/

        // grid.getChildAt(i).setImageResource(drawables.get(cards.get(i)))


        for (i in 0 until rHistory.size) {
            var currentRoll = rHistory[i]
// print out timestamp here

                    for (j in 0 until currentRoll.noOfDice.size)
            {
                s +=  "${currentRoll.noOfDice[j]?.plus(1)} "
                tvHisory.text = s
            }
            q = "${currentRoll.timestamp} "
            timeArray + q

            s += "\n"


        }
        print()
    }

    fun print(){
        tvTimeStamp.text = timeArray.toString()
    }

    //val profileName=intent.getStringExtra("roll")

    fun onClickClear(view: View) {
        rHistory.clear()
        updateHistory()
    }
    fun updateHistory(){
        var s = ""
        //rollHistory.forEach{ p -> val e1 = p.first; val e2 = p.second
        //    s += "$e1 - $e2\n"}
        tvHisory.text = s
    }
}

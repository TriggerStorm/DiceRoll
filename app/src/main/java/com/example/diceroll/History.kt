package com.example.diceroll

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_history.*

class History : AppCompatActivity() {

    var mhistory = MainActivity.mHistory

    var diceRoll: Array<ImageView?> = arrayOfNulls<ImageView>(5)

    val diceIds = arrayOf(R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        var s = ""
        mhistory.forEach{ p -> val e1 = p.first; val e2 = p.second
            s += "$e1 - $e2\n"}
        tvHisory.text = s

        /*for (int i = 0; i < mhistory.size; i++) {

            for (int x = )
            int res = getResources().getIdentifier("i"+i, "id", getPackageName());
            letters[i] = (ImageView) findViewById(res);*/
    }

    //val profileName=intent.getStringExtra("roll")

    fun onClickClear(view: View) {
        mhistory.clear()
        updateHistory()
    }
    fun updateHistory(){
        var s = ""
        mhistory.forEach{ p -> val e1 = p.first; val e2 = p.second
            s += "$e1 - $e2\n"}
            tvHisory.text = s
    }
}

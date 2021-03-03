package com.example.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_history.*

class History : AppCompatActivity() {

    var mhistory = MainActivity.mHistory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        tvHisory.text = mhistory.toString()
    }

    //val profileName=intent.getStringExtra("roll")

    fun onClickClear(view: View) {
        mhistory.clear()
        updateHistory()
    }
    fun updateHistory(){
        tvHisory.text = mhistory.toString()
    }
}
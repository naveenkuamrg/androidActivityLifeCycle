package com.example.activitylifecycle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class ThridActivity : MainActivity() {
    var txt : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        txt =   TextView(this).apply {
            text = "new"
        }
        super.onCreate(savedInstanceState)
        val intentFirstClass = Intent(this, FirstActivity::class.java)
        val intentSecondClass = Intent(this,SecondActivity::class.java)
        val btn1 = Button(this).apply {
            setOnClickListener {
                startActivity(intentFirstClass)
            }
            text = "FirstAcitivity"
        }
        val btn2 = Button(this).apply {
            setOnClickListener {
                startActivity(intentSecondClass)
            }
            text = "SecondActivity"
        }

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            addView(btn1)
            addView(btn2)
            addView(txt)


        }
        setContentView(layout)
    }

    override fun onStart() {
        super.onStart()
        txt?.text = getAppTaskState().toString()
    }


    override fun onDestroy() {
        super.onDestroy()
        this.intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)

    }
}
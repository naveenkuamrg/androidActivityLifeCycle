package com.example.activitylifecycle
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class TestActivity : MainActivity() {
    var txt : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var intent = Intent(this,TestActivity::class.java)
        var btn1 = Button(this).apply {
            text = "create new activity"

            setOnClickListener {
                startActivity(intent)
            }
        }
        txt = TextView(this).apply {
            text = "create"
        }
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            addView(btn1)
            addView(txt)
        }



        setContentView(layout)




    }


    override fun onStart() {
        super.onStart()
        txt?.text = getAppTaskState()
    }
}
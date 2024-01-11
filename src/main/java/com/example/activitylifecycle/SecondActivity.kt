package com.example.activitylifecycle

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.activitylifecycle.ui.theme.ActivityLifecycleTheme

class SecondActivity : MainActivity() {
    var textView : EditText? = null
    var txt : TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         txt =  TextView(this).apply {
            text = "new"
        }

        Log.i("TAG", "on Create function")

        textView = EditText(this).apply {
            hint = "This is a TextView created programmatically"
            inputType = InputType.TYPE_CLASS_TEXT
            textSize = 20f
            gravity = Gravity.CENTER
        }
        val intent = Intent(this, ThridActivity::class.java)
        val btn1 = Button(this).apply {
            setOnClickListener {
                startActivity(intent)
            }
            text = "Thrid  New Activity"
        }


        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            addView(textView)
            addView(btn1)
            addView(txt)

        }

//        layout.addView(textView)
        lifecycle.addObserver(MyObserver())
        setContentView(layout)
    }



    override fun onStart() {
        super.onStart()
        Log.i("TAG","SecondActivity on start function")
        txt?.text = getAppTaskState().toString()

    }

    override fun onResume() {
        super.onResume()
        Log.i("TAG","SecondActivity on Resume function")
    }

    override fun onPause() {
        super.onPause()
        Log.i("TAG","SecondActivity on onPause function")
//        textView.editableText
    }

    override fun onStop() {
        super.onStop()
        Log.i("TAG","SecondActivity on Stop function")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("Tag","Second Activity on save InstanceState")
    }
    override fun onRestart() {
        super.onRestart()
        Log.i("TAG","SecondActivity on Restart function ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("TAG","SecondActivity on Destroy function ")
    }

    override fun finish() {
        super.finish()
        Log.i("TAG","Second Finish activity")
    }
}
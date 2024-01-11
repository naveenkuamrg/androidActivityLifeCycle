package com.example.activitylifecycle
import android.content.Intent
import android.os.Bundle
import android.util.LayoutDirection
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.ComponentActivity

class PaymentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val successBtn = Button(this).apply {
            text = "success"
            setOnClickListener {
                setResult(RESULT_OK)
                finish()
            }
        }
        val cancelBtn = Button(this).apply {
            text = "cancel"
            setOnClickListener {
              setResult(RESULT_CANCELED)
                finish()
            }
        }

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            addView(successBtn)
            addView(cancelBtn)
        }

        setContentView(layout)



    }


    override fun onDestroy() {
        super.onDestroy()
    }


    override fun finish() {
        finishAndRemoveTask()
    }
}
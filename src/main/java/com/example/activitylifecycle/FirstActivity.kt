package com.example.activitylifecycle

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.text.InputType
import android.text.SpannableStringBuilder
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider

class FirstActivity : MainActivity() {
    companion object{
        var RESULT_CODE = 0
    }
    var textView : EditText? = null
    var txt : TextView? = null
    private val theam: SampleViewModel by lazy {
        ViewModelProvider(this).get(SampleViewModel::class.java)
    }
    val myLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
       Log.i("TAG","NEW CODE : ${result.resultCode}")
    }



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
        val intent = Intent(this, SecondActivity::class.java)
        val intent1 = Intent()
        intent1.setAction("android.intent.action.SEND")
        intent1.addCategory("android.intent.category.DEFAULT")
        val callIntent: Intent = Uri.parse("tel:5551234").let { number ->
            Intent(Intent.ACTION_DIAL, number)
        }
        val payment = Intent(this,PaymentActivity::class.java)

        val btn3 = Button(this).apply {
            text = "Tap to pay"
            setOnClickListener {
                startActivity(payment)
//                startActivityForResult(payment,RESULT_CODE)
                Log.i("Result Code","CODE : $RESULT_CODE")
//                myLauncher.launch(payment)
            }
        }
        val btn1 = Button(this).apply {
            setOnClickListener {
                startActivity(intent)
            }
            text = "New Activity"
            highlightColor = Color.BLUE

        }


        val btn2 = Button(this).apply {
            text = "Change color"
            txt?.setTextColor(theam.backgroundColor)
            setOnClickListener {
                theam.changeTheam()
                txt?.setTextColor(theam.backgroundColor)
            }
        }




        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            addView(textView)
            addView(btn1)
            addView(txt)
            addView(btn2)
            addView(btn3)

        }


//        layout.addView(textView)
        lifecycle.addObserver(MyObserver())
        setContentView(layout)




    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val str = textView!!.text.toString()

        outState.putString("SampleText",textView?.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val str = savedInstanceState.getString("SampleText")
        textView?.text = SpannableStringBuilder(str)
    }

    override fun onStart() {
        super.onStart()
        Log.i("TAG","First on start function")

        txt?.text = getAppTaskState().toString()

    }

    override fun onResume() {
        super.onResume()
        Log.i("TAG","First on Resume function")
        val person = Person("naveen",12)
        val arrayList = ArrayList<Parcelable>()
        arrayList.add(person)
        intent.putParcelableArrayListExtra("person",arrayList)
        val person1 = intent.getParcelableArrayListExtra<Person>("person")?.get(0)
        Log.i("TAG",person1!!.name)


    }

    override fun onPause() {

        super.onPause()
        Log.i("TAG","First on onPause function")
//        textView.editableText
    }

    override fun onStop() {
        super.onStop()
        Log.i("TAG","First on Stop function")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("TAG","First on Restart function ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("TAG","First on Destroy function ")
    }

    override fun finish() {
        super.finish()
        Log.i("TAG","Frist Finish")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.i("TAG","CODE  :${resultCode == RESULT_OK}")
    }

}
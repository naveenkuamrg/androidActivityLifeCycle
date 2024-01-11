package com.example.activitylifecycle

import android.graphics.Color
import android.util.Log
import androidx.lifecycle.ViewModel

class SampleViewModel : ViewModel() {

    var backgroundColor = Color.GREEN
    init {

        Log.i("TAg","Life is start")
    }


    fun changeTheam(){
        backgroundColor = if(backgroundColor == Color.GREEN) {
            Color.CYAN
        }else{
            Color.GREEN
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("TAg","Life is over")
    }

}
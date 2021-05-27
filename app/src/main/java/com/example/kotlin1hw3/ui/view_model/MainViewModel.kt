package com.example.kotlin1hw3.ui.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var mCounter = 0
    private val builder = StringBuilder()

    val counter = MutableLiveData<Int>()
    val counterSign = MutableLiveData<String>()

    fun onPlusClick(){
        mCounter++
        counter.value = mCounter
        counterSign.value = builder.toString()
        builder.append(" " + " + ")
    }

    fun onMinusClick(){
        mCounter--
        counter.value = mCounter
        counterSign.value = builder.toString()
        builder.append(" " + " - ")
    }

    init {
        counter.postValue(0)
        counterSign.postValue("")
    }

}
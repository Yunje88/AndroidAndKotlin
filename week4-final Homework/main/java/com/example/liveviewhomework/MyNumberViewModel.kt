package com.example.liveviewhomework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



class MyNumberViewModel : ViewModel(){

    private val _currentValue = MutableLiveData<Int>()

    val currentValue: LiveData<Int>
        get() = _currentValue

    // init value
    init {

        _currentValue.value = 0

    }

    fun updateValue(input: Int){

        _currentValue.value = _currentValue.value?.plus(input)

    }

}
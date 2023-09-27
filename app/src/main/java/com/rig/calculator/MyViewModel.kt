package com.rig.calculator

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.notkamui.keval.Keval

class MyViewModel():ViewModel() {
    var valueNumber:MutableState<String> = mutableStateOf("")

    fun evalFunction(state: String) {
        var test = Keval.eval(state)
        valueNumber.value = test.toString()
    }
}
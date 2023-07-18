package com.example.test_nhl_project.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoneyViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {

    var counter = 20
        set(value) {
            field = value
            moneyCounterLiveData.value = value
        }
    val moneyCounterLiveData = MutableLiveData<Int>(counter)


    fun collectMoney(){
     counter++
    }
}
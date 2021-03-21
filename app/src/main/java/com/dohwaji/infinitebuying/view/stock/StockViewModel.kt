package com.dohwaji.infinitebuying.view.stock

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StockViewModel : ViewModel() {
    val text = MutableLiveData<String>()
}
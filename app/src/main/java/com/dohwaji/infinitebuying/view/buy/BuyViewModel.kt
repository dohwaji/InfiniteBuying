package com.dohwaji.infinitebuying.view.buy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dohwaji.infinitebuying.repository.StockRepository

class BuyViewModel : ViewModel() {
    var stockList = StockRepository.getStockList()
}
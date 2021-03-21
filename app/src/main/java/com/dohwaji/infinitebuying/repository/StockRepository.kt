package com.dohwaji.infinitebuying.repository

import androidx.lifecycle.MutableLiveData
import com.dohwaji.infinitebuying.db.LocalDataLoader
import com.dohwaji.infinitebuying.db.model.BuyHistoryDto
import com.dohwaji.infinitebuying.db.model.StockHistoryDto
import com.dohwaji.infinitebuying.model.Stock
import com.dohwaji.infinitebuying.model.StockList

object StockRepository {
    private var stockList = MutableLiveData<StockList>()

    init {
        getStockListFromDB()
    }

    fun getStockList() : MutableLiveData<StockList> {
        return stockList
    }

    fun getStockHistory(ticker: String, tickerRound: Int) : List<StockHistoryDto> {
        return LocalDataLoader.getInstance().getStockHistory(ticker, tickerRound)
    }

    fun getBuyHistory(ticker: String, tickerRound: Int) : List<BuyHistoryDto> {
        return LocalDataLoader.getInstance().getBuyHistory(ticker, tickerRound)
    }

    private fun getStockListFromDB() {
        val labu = Stock("Direxion Daily S&P Biotech Bull 3X Shares ETF", "LABU")
        val soxl = Stock("Direxion Daily Semiconductor Bull 3X Shares", "SOXL")
        val nail = Stock("Direxion Daily Homebuilders & Supplies Bull 3X Shs", "NAIL")
        val tqqq = Stock("ProShares UltraPro QQQ", "TQQQ")
        val dfen = Stock("Direxion Daily Aerospace & Defense Bull 3X Shares", "DFEN")
        val fngu = Stock("Bank of Montreal MicroSectors FANG Index 3X Leveraged ETN Exp 8 Jan 2038", "FNGU")

        val list = arrayListOf(labu, soxl, nail, tqqq, dfen, fngu)
        val stocks = StockList(list)
        stockList.postValue(stocks)
    }
}
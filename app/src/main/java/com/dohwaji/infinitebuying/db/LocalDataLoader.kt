package com.dohwaji.infinitebuying.db

import androidx.room.Room
import com.dohwaji.infinitebuying.Const
import com.dohwaji.infinitebuying.InfiniteApplication
import com.dohwaji.infinitebuying.db.model.BuyHistoryDto
import com.dohwaji.infinitebuying.db.model.StockHistoryDto

class LocalDataLoader private constructor() {

    companion object {
        private var instance: LocalDataLoader? = null

        @JvmStatic
        fun getInstance(): LocalDataLoader {
            return instance ?: synchronized(this) {
                instance ?: LocalDataLoader().also { instance = it }
            }
        }
    }

    private val stockHistoryDao: StockHistoryDao
    private val buyHistoryDao: BuyHistoryDao

    init {
        val db = Room.databaseBuilder(InfiniteApplication.getAppContext(), InfiniteDB::class.java, Const.DB_NAME).build()
        stockHistoryDao = db.stockHistoryDao()
        buyHistoryDao = db.buyHistoryDao()
    }

    fun getStockHistory(ticker: String, tickerRound: Int) : List<StockHistoryDto> {
        return stockHistoryDao.select(ticker, tickerRound)
    }

    fun getBuyHistory(ticker: String, tickerRound: Int) : List<BuyHistoryDto> {
        return buyHistoryDao.selectBuyHistory(ticker, tickerRound)
    }
}
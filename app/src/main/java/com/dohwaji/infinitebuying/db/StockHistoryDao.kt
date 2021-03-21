package com.dohwaji.infinitebuying.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dohwaji.infinitebuying.Const
import com.dohwaji.infinitebuying.db.model.StockHistoryDto

@Dao
interface StockHistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(stockHistoryDto: StockHistoryDto)

    @Query("SELECT * FROM ${Const.TABLE_STOCK} WHERE ticker=:ticker AND ticker_round=:ticker_round")
    fun select(ticker: String, ticker_round: Int): List<StockHistoryDto>

    @Query("DELETE FROM ${Const.TABLE_STOCK} WHERE ticker=:ticker AND ticker_round=:ticker_round")
    fun delete(ticker: String, ticker_round: Int)
}
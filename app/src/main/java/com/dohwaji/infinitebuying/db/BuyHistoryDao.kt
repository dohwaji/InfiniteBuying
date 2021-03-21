package com.dohwaji.infinitebuying.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dohwaji.infinitebuying.Const
import com.dohwaji.infinitebuying.db.model.BuyHistoryDto

@Dao
interface BuyHistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(buyHistoryDto: BuyHistoryDto)

    @Query("SELECT * FROM ${Const.TABLE_BUY} WHERE ticker=:ticker AND ticker_round=:ticker_round")
    fun selectBuyHistory(ticker: String, ticker_round: Int): List<BuyHistoryDto>

    @Query("DELETE FROM ${Const.TABLE_BUY} WHERE ticker=:ticker AND ticker_round=:ticker_round")
    fun deleteBuyHistory(ticker: String, ticker_round: Int)
}
package com.dohwaji.infinitebuying.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dohwaji.infinitebuying.Const
import com.dohwaji.infinitebuying.db.model.BuyHistoryDto
import com.dohwaji.infinitebuying.db.model.StockHistoryDto

@Database(entities = [StockHistoryDto::class, BuyHistoryDto::class], version = Const.DB_VERSION, exportSchema = false)
abstract class InfiniteDB: RoomDatabase() {
    abstract fun buyHistoryDao(): BuyHistoryDao
    abstract fun stockHistoryDao(): StockHistoryDao
}
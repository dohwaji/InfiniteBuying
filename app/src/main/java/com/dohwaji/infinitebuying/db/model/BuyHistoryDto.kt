package com.dohwaji.infinitebuying.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dohwaji.infinitebuying.Const

@Entity(tableName = Const.TABLE_BUY)
class BuyHistoryDto(
    @PrimaryKey @ColumnInfo(name = "id") val id: Long, //id
    @ColumnInfo(name = "ticker") val ticker: String, //주식 코드
    @ColumnInfo(name = "ticker_round") val ticker_round: Int, //ticker 회차
    @ColumnInfo(name = "stock_round") val stock_round: Int, //구매 회차
    @ColumnInfo(name = "buy_date") val buy_date: Long,  //매매날짜
    @ColumnInfo(name = "price") val price: Int, //매수단가
    @ColumnInfo(name = "count") val count: Int, //구매수량
)
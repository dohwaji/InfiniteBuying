package com.dohwaji.infinitebuying.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dohwaji.infinitebuying.Const

@Entity(tableName = Const.TABLE_STOCK)
class StockHistoryDto (
    @PrimaryKey @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "ticker") val ticker: String, //ticker
    @ColumnInfo(name = "name") val name: String, //주식명
    @ColumnInfo(name = "ticker_round") val ticker_round: Int, //ticker 회차
    @ColumnInfo(name = "buy_count_per_day") val buy_count_per_day: Int, //하루 매수 횟수
    @ColumnInfo(name = "start_date") val start_date: Long, //시작날짜
    @ColumnInfo(name = "end_date") val end_date: Long, //종료날짜
)
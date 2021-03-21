package com.dohwaji.infinitebuying.model

data class Stock(
    val name: String,
    val ticker: String
)

data class StockList(
    val stocks: List<Stock> = emptyList()
)
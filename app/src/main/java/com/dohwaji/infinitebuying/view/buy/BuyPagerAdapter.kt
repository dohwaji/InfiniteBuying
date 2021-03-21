package com.dohwaji.infinitebuying.view.buy

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dohwaji.infinitebuying.model.StockList
import com.dohwaji.infinitebuying.view.stock.StockFragment

class BuyPagerAdapter(fragment: Fragment, private var stockList: MutableLiveData<StockList>) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        if(stockList.value != null) {
            return stockList.value!!.stocks.size
        }

        return 0
    }

    override fun createFragment(position: Int): Fragment {
        return StockFragment(position)
    }

}
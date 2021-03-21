package com.dohwaji.infinitebuying.view.buy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.dohwaji.infinitebuying.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class BuyFragment : Fragment() {

    private lateinit var buyViewModel: BuyViewModel
    private lateinit var buyViewPagerAdapter: BuyPagerAdapter
    private lateinit var buyViewPager: ViewPager2

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        buyViewModel =
                ViewModelProvider(this).get(BuyViewModel::class.java)
        return inflater.inflate(R.layout.fragment_buy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buyViewPagerAdapter = BuyPagerAdapter(this, buyViewModel.stockList)
        buyViewPager = view.findViewById(R.id.buy_pager)
        buyViewPager.apply {
            adapter = buyViewPagerAdapter
        }

        val tabLayout = view.findViewById<TabLayout>(R.id.buy_tab)
        buyViewModel.stockList.observe(this.viewLifecycleOwner, {
            TabLayoutMediator(tabLayout, buyViewPager) { tab, position ->
                tab.text = it.stocks[position].ticker
            }.attach()
            buyViewPagerAdapter.notifyDataSetChanged()
        })
    }
}
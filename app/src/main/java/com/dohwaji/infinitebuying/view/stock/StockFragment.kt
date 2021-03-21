package com.dohwaji.infinitebuying.view.stock

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dohwaji.infinitebuying.R
import com.dohwaji.infinitebuying.databinding.FragmentStockBinding
import com.dohwaji.infinitebuying.model.Stock
import com.dohwaji.infinitebuying.repository.StockRepository

class StockFragment(private val position: Int) : Fragment() {
    private lateinit var binding: FragmentStockBinding
    private lateinit var stock: Stock

    private val stockViewModel: StockViewModel by lazy {  ViewModelProvider(this@StockFragment).get(StockViewModel::class.java) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentStockBinding.inflate(inflater, container, false)
            .apply {
                vm = stockViewModel
                lifecycleOwner = this@StockFragment
            }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        loadData()
        initUI()
    }

    private fun initViewModel() {
        stockViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.stockName.text = it
        })
    }

    private fun loadData() {
        stock = StockRepository.getStockList().value!!.stocks[position]
    }

    private fun initUI() {
        stockViewModel.text.postValue(stock.name)
    }
}
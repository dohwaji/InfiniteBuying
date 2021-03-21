package com.dohwaji.infinitebuying.view.done

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dohwaji.infinitebuying.R

class DoneFragment : Fragment() {

    private lateinit var doneViewModel: DoneViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        doneViewModel =
                ViewModelProvider(this).get(DoneViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_done, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        doneViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
package com.example.kotlin1hw3.ui.third_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin1hw3.R
import com.example.kotlin1hw3.ui.view_model.MainViewModel
import kotlinx.android.synthetic.main.fragment_third.*

class ThirdFragment : Fragment() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.counterSign.observe(viewLifecycleOwner, Observer {data ->
            txt_view_third.text = data.toString()
        })
    }

    companion object {
        fun newInstance() = ThirdFragment()
    }

}
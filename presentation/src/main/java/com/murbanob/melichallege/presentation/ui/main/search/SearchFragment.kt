package com.murbanob.melichallege.presentation.ui.main.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.murbanob.melichallege.presentation.databinding.FragmentSearchItemBinding
import com.murbanob.melichallege.presentation.ui.base.BaseFragment

class SearchFragment : BaseFragment() {

    private var _binding: FragmentSearchItemBinding? = null
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchItemBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
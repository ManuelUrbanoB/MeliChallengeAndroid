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
    private var onSearchResult: ((value: String) -> Unit)? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchItemBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeConfigurationSearchView()
    }

    private fun changeConfigurationSearchView() {
        binding?.searchView?.setIconifiedByDefault(true)
        binding?.searchView?.isFocusable = true
        binding?.searchView?.isIconified = false
        binding?.searchView?.requestFocusFromTouch()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        val TAG: String = SearchFragment::class.java.simpleName
        fun createInstance(onSearchResult: ((value: String) -> Unit)): SearchFragment {
            return SearchFragment().apply {
                this.onSearchResult = onSearchResult
            }
        }
    }

}
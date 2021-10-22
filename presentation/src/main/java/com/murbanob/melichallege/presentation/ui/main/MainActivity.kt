package com.murbanob.melichallege.presentation.ui.main

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.murbanob.melichallege.presentation.R
import com.murbanob.melichallege.presentation.databinding.ActivityMainBinding
import com.murbanob.melichallege.presentation.extension.attachFragment
import com.murbanob.melichallege.presentation.ui.base.BaseActivity
import com.murbanob.melichallege.presentation.ui.main.itemAdapter.ItemAdapter
import com.murbanob.melichallege.presentation.ui.search.SearchFragment
import com.murbanob.melichallenge.domain.entities.Item
import com.murbanob.melichallenge.domain.entities.ItemSearchResponse
import com.murbanob.melichallenge.domain.helpers.Result

class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    private val searchFragment: SearchFragment = SearchFragment.createInstance(::searchItems)
    private val adapterList: ItemAdapter = ItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        attachFragments()
        setRecyclerView()
        setObservers()
    }

    private fun attachFragments() {
        attachSearchFragment()
    }

    private fun attachSearchFragment() {
        supportFragmentManager.attachFragment(
            containerId = R.id.fragmentSearchView,
            fragment = searchFragment,
            tag = SearchFragment.TAG
        )
    }

    private fun setRecyclerView() {
        binding.recyclerItems.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = adapterList
        }
    }

    private fun searchItems(value: String) {
        binding.progressBar.visibility = View.VISIBLE
        viewModel.searchItems(value)
    }

    private fun setObservers() {
        viewModel.getResultItemLiveData.observe(this, Observer(::manageResponseItems))
    }

    private fun manageResponseItems(result: Result<ItemSearchResponse>) {
        binding.progressBar.visibility = View.GONE
        when (result) {
            is Result.Success -> {
                adapterList.items = result.data.items
            }
            else -> {
                //TODO Show Error here
            }
        }
    }
}
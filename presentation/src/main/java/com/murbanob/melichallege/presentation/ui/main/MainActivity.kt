package com.murbanob.melichallege.presentation.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.murbanob.melichallege.presentation.R
import com.murbanob.melichallege.presentation.databinding.ActivityMainBinding
import com.murbanob.melichallege.presentation.extension.attachFragment
import com.murbanob.melichallege.presentation.ui.base.BaseActivity
import com.murbanob.melichallege.presentation.ui.detail.DetailItemActivity
import com.murbanob.melichallege.presentation.ui.main.itemAdapter.ItemAdapter
import com.murbanob.melichallege.presentation.ui.search.SearchFragment
import com.murbanob.melichallenge.domain.entities.ItemSearch
import com.murbanob.melichallenge.domain.entities.ItemSearchResponse
import com.murbanob.melichallenge.domain.helpers.ErrorResult
import com.murbanob.melichallenge.domain.helpers.Result

class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    private val searchFragment: SearchFragment = SearchFragment.createInstance(::searchItems)
    private val adapterList: ItemAdapter = ItemAdapter(::onTapDetail)

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

    private fun setObservers() {
        viewModel.getResultItemLiveData.observe(this, Observer(::manageResponseItems))
    }

    private fun setRecyclerView() {
        binding.recyclerItems.apply {
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
            adapter = adapterList
        }
    }

    private fun searchItems(value: String) {
        binding.progressBar.visibility = View.VISIBLE
        viewModel.searchItems(value)
    }

    private fun manageResponseItems(result: Result<ItemSearchResponse>) {
        binding.progressBar.visibility = View.GONE
        when (result) {
            is Result.Success -> {
                adapterList.updateItems(result.data.itemSearches)
            }
            is Result.Error -> {
                showSnackBarErrorInResultOfItems(result.exception)
            }
        }
    }

    private fun showSnackBarErrorInResultOfItems(exception: Exception) {
        Snackbar
            .make(
                binding.fragmentSearchView,
                ErrorResult.getException(exception = exception).getMessageToUser(),
                Snackbar.LENGTH_LONG
            )
            .show()
    }

    private fun onTapDetail(itemSearch: ItemSearch) {
        val intent = Intent(this, DetailItemActivity::class.java)
        intent.putExtra(DetailItemActivity.ITEM_DETAIL, itemSearch.id)
        startActivity(intent)
    }
}
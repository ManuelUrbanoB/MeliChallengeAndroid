package com.murbanob.melichallege.presentation.ui.main

import android.os.Bundle
import com.murbanob.melichallege.presentation.R
import com.murbanob.melichallege.presentation.databinding.ActivityMainBinding
import com.murbanob.melichallege.presentation.extension.attachFragment
import com.murbanob.melichallege.presentation.ui.base.BaseActivity
import com.murbanob.melichallege.presentation.ui.main.search.SearchFragment

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val searchFragment: SearchFragment = SearchFragment.createInstance(::searchItems)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        attachFragments()
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

    private fun searchItems(value: String) {

    }
}
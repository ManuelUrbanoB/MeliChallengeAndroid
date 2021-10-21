package com.murbanob.melichallege.presentation.ui.main

import android.os.Bundle
import com.murbanob.melichallege.presentation.R
import com.murbanob.melichallege.presentation.databinding.ActivityMainBinding
import com.murbanob.melichallege.presentation.ui.base.BaseActivity

class MainActivity : BaseActivity() {
    private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
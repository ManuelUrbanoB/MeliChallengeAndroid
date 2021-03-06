package com.murbanob.melichallege.presentation.ui.detail

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.murbanob.melichallege.presentation.R
import com.murbanob.melichallege.presentation.databinding.ActivityDetailItemBinding
import com.murbanob.melichallege.presentation.extension.showErrorRequestSnackBar
import com.murbanob.melichallege.presentation.ui.base.BaseActivity
import com.murbanob.melichallege.presentation.ui.detail.pictureAdapter.PictureAdapter
import com.murbanob.melichallenge.domain.entities.ItemDetail
import com.murbanob.melichallenge.domain.helpers.Result


class DetailItemActivity : BaseActivity() {

    private val viewModel: DetailItemViewModel by viewModels()

    private lateinit var binding: ActivityDetailItemBinding
    private lateinit var itemSearchId: String
    private var adapterPictures: PictureAdapter = PictureAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        reviewItemSearch()
        setRecyclerView()
        setObservers()
        getItem()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun reviewItemSearch() {
        val bundle = intent.extras
        val itemSearchId = bundle?.getString(ITEM_DETAIL)
        if (itemSearchId == null) {
            createToastNowFound()
            finish()
            return
        }
        this.itemSearchId = itemSearchId
    }

    private fun createToastNowFound() {
        Toast.makeText(
            this,
            getString(R.string.item_was_not_found),
            Toast.LENGTH_LONG
        ).show()
    }

    private fun setRecyclerView() {
        binding.viewPagerPictures.apply {
            adapter = adapterPictures
        }
    }

    private fun setObservers() {
        viewModel.getItemDetailLiveData.observe(this, Observer(::manageResponseItemDetail))
    }

    private fun manageResponseItemDetail(result: Result<ItemDetail>) {
        binding.progressBar.visibility = View.GONE
        when (result) {
            is Result.Success -> {
                adapterPictures.updateList(result.data.pictures)
                binding.textTitleView.text = result.data.title
                binding.textPriceView.text =
                    result.data.getPriceFormat()
            }
            is Result.Error -> {
                binding.viewPagerPictures.showErrorRequestSnackBar(result.exception)
            }
        }
    }

    private fun getItem() {
        binding.progressBar.visibility = View.VISIBLE
        viewModel.getItemDetail(itemSearchId)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val ITEM_DETAIL = "ITEM_DETAIL"
    }
}
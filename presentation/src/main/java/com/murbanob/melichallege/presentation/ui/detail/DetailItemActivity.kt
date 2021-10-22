package com.murbanob.melichallege.presentation.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.murbanob.melichallege.presentation.R
import com.murbanob.melichallenge.domain.helpers.Result
import com.murbanob.melichallege.presentation.databinding.ActivityDetailItemBinding
import com.murbanob.melichallege.presentation.ui.base.BaseActivity
import com.murbanob.melichallege.presentation.ui.detail.pictureAdapter.PictureAdapter
import com.murbanob.melichallenge.domain.entities.ItemDetail
import com.murbanob.melichallenge.domain.helpers.ErrorResult


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
        binding.recyclePictures.apply {
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
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
                binding.textPriceView.text = result.data.price
            }
            is Result.Error -> {
                showSnackBarErrorInResultOfItems(result.exception)
            }
        }
    }

    private fun showSnackBarErrorInResultOfItems(exception: Exception) {
        Snackbar
            .make(
                binding.recyclePictures,
                ErrorResult.getException(exception = exception).getMessageToUser(),
                Snackbar.LENGTH_LONG
            )
            .show()
    }

    private fun getItem() {
        binding.progressBar.visibility = View.VISIBLE
        viewModel.getItemDetail(itemSearchId)
    }

    companion object {
        const val ITEM_DETAIL = "ITEM_DETAIL"
    }
}
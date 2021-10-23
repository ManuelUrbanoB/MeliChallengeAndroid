package com.murbanob.melichallege.presentation.ui.main.itemAdapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.murbanob.melichallege.presentation.R
import com.murbanob.melichallenge.domain.extension.getPriceFormat
import com.murbanob.melichallenge.domain.entities.ItemSearch


class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private lateinit var imageView: ImageView
    private lateinit var textTitleView: TextView
    private lateinit var textPriceView: TextView
    private lateinit var onTapItemListener: (ItemSearch) -> Unit

    fun bind(itemSearch: ItemSearch, onTapItemListener: (ItemSearch) -> Unit) {
        this.onTapItemListener = onTapItemListener
        getViews()
        setInformationInView(itemSearch)
        setListeners(itemSearch)
    }

    private fun getViews() {
        imageView = itemView.findViewById(R.id.imageItem)
        textTitleView = itemView.findViewById(R.id.textTitleItem)
        textPriceView = itemView.findViewById(R.id.textPriceItem)
    }

    private fun setInformationInView(itemSearch: ItemSearch) {
        loadImage(itemSearch.thumbnail)
        textTitleView.text = itemSearch.title
        textPriceView.text = itemSearch.getPriceFormat()
    }

    private fun loadImage(url: String) {
        Glide.with(imageView)
            .load(url)
            .into(imageView)
    }

    private fun setListeners(itemSearch: ItemSearch) {
        itemView.setOnClickListener {
            onTapItemListener.invoke(itemSearch)
        }
    }
}
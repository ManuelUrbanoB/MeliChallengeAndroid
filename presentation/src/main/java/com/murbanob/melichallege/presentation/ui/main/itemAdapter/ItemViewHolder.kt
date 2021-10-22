package com.murbanob.melichallege.presentation.ui.main.itemAdapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.murbanob.melichallege.presentation.R
import com.murbanob.melichallenge.domain.entities.Item


class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private lateinit var imageView: ImageView
    private lateinit var textTitleView: TextView
    private lateinit var textPriceView: TextView

    fun bind(item: Item) {
        getViews()
        setInformationInView(item)
    }

    private fun getViews() {
        imageView = itemView.findViewById(R.id.imageItem)
        textTitleView = itemView.findViewById(R.id.textTitleItem)
        textPriceView = itemView.findViewById(R.id.textPriceItem)
    }

    private fun setInformationInView(item: Item) {
        loadImage(item.thumbnail)
        textTitleView.text = item.title
        textPriceView.text = item.price
    }

    private fun loadImage(url: String) {
        Glide.with(imageView)
            .load(url)
            .into(imageView)
    }
}
package com.murbanob.melichallege.presentation.ui.detail.pictureAdapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.murbanob.melichallege.presentation.R
import com.murbanob.melichallenge.domain.entities.ItemDetail
import com.murbanob.melichallenge.domain.entities.ItemDetailPicture

class PictureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private lateinit var imageView: ImageView

    fun bind(item: ItemDetailPicture) {
        getViews()
        setInformationInView(item.url)
    }

    private fun getViews() {
        imageView = itemView.findViewById(R.id.imageView)
    }

    private fun setInformationInView(url: String) {
        Glide.with(imageView)
            .load(url)
            .into(imageView)
    }
}
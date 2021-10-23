package com.murbanob.melichallege.presentation.ui.detail.pictureAdapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.murbanob.melichallege.presentation.R
import com.murbanob.melichallege.presentation.extension.inflate
import com.murbanob.melichallenge.domain.entities.ItemDetailPicture

class PictureAdapter : RecyclerView.Adapter<PictureViewHolder>() {

    private var pictures: List<ItemDetailPicture> = emptyList()
        set(value) {
            field = value
            notifyItemRangeChanged(0, value.size - 1)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder =
        PictureViewHolder(parent.inflate(R.layout.picture_view))

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        holder.bind(pictures[position])
    }

    override fun getItemCount(): Int = pictures.size

    fun updateList(pictures: List<ItemDetailPicture>) {
        this.pictures = pictures
    }
}
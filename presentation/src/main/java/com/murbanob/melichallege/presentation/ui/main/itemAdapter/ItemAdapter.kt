package com.murbanob.melichallege.presentation.ui.main.itemAdapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.murbanob.melichallege.presentation.R
import com.murbanob.melichallege.presentation.extension.inflate
import com.murbanob.melichallenge.domain.entities.Item

class ItemAdapter : RecyclerView.Adapter<ItemViewHolder>() {

    private var items = listOf<Item>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(parent.inflate(R.layout.item_adapter))

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun updateItems(items: List<Item>) {
        this.items = items
    }

    override fun getItemCount(): Int = items.size
}
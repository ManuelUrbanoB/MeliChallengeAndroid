package com.murbanob.melichallege.presentation.ui.main.itemAdapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.murbanob.melichallege.presentation.R
import com.murbanob.melichallege.presentation.extension.inflate
import com.murbanob.melichallenge.domain.entities.ItemSearch

class ItemAdapter(private val onTapItemListener: (ItemSearch) -> Unit) :
    RecyclerView.Adapter<ItemViewHolder>() {

    private var items = listOf<ItemSearch>()
        set(value) {
            field = value
            notifyItemRangeChanged(0, value.size - 1)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(parent.inflate(R.layout.item_list_adapter))

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position], onTapItemListener)
    }

    fun updateItems(itemSearches: List<ItemSearch>) {
        this.items = itemSearches
    }

    override fun getItemCount(): Int = items.size
}
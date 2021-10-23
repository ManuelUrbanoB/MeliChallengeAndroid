package com.murbanob.melichallenge.domain.entities

import com.murbanob.melichallenge.domain.extension.getPriceFormat

data class ItemDetail(
    val id: String,
    val title: String,
    val price: Double,
    val currencyId: String,
    val pictures: List<ItemDetailPicture>
){
    fun getPriceFormat(): String {
        return price.getPriceFormat(currency = currencyId).replace(currencyId, "$")
    }
}
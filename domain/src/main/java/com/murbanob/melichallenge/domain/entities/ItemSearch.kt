package com.murbanob.melichallenge.domain.entities

import com.murbanob.melichallenge.domain.extension.getPriceFormat

data class ItemSearch(
    var id: String,
    var title: String,
    var price: Double,
    var permalink: String,
    var thumbnail: String,
    var soldQuantity: String,
    var currencyId: String
) {
    fun getPriceFormat(): String {
        return price.getPriceFormat(currency = currencyId).replace(currencyId, "$")
    }
}
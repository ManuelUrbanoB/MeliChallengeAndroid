package com.murbanob.melichallenge.domain.entities

data class ItemSearch(
    var id: String,
    var title: String,
    var price: String,
    var permalink: String,
    var thumbnail: String,
    var soldQuantity: String,
    var currencyId: String
)
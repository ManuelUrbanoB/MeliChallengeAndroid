package com.murbanob.melichallenge.domain.entities

data class Item(
    var id: String,
    var title: String,
    var price: String,
    var permalink: String,
    var thumbnail: String,
    var sold_quantity: String
)
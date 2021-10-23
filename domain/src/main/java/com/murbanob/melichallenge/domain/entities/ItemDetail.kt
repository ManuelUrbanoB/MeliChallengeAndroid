package com.murbanob.melichallenge.domain.entities

class ItemDetail(
    val id: String,
    val title: String,
    val price: String,
    val currencyId: String,
    val pictures: List<ItemDetailPicture>
)
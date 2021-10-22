package com.murbanob.melichallenge.data.api.entities

import com.google.gson.annotations.SerializedName

data class ItemDetailResponseApi(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("currency_id")
    val currency_id: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("pictures")
    val pictures: List<ItemDetailPicturesApi>
)
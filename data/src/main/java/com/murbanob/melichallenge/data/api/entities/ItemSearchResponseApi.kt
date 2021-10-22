package com.murbanob.melichallenge.data.api.entities

import com.google.gson.annotations.SerializedName

data class ItemSearchResponseApi(
    @SerializedName("id")
    var id: String,
    @SerializedName("site_id")
    var siteId: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("price")
    var price: String,
    @SerializedName("sale_price")
    var sale_price: String?,
    @SerializedName("permalink")
    var permalink: String,
    @SerializedName("thumbnail")
    var thumbnail: String,
    @SerializedName("sold_quantity")
    var sold_quantity: String,
    @SerializedName("currency_id")
    var currency_id: String
)
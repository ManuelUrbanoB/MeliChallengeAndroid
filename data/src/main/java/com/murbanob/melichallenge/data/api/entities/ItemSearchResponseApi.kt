package com.murbanob.melichallenge.data.api.entities

import com.google.gson.annotations.SerializedName

data class ItemSearchResponseApi(
    @SerializedName("site_id")
    var siteId: String,
    @SerializedName("query")
    var query: String,
    @SerializedName("results")
    var results: List<ItemResponseApi>
)
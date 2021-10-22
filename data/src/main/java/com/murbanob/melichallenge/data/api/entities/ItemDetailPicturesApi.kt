package com.murbanob.melichallenge.data.api.entities

import com.google.gson.annotations.SerializedName

class ItemDetailPicturesApi(
    @SerializedName("id")
    var id: String,
    @SerializedName("url")
    var url: String,
    @SerializedName("secure_url")
    var secure_url: String,
    @SerializedName("size")
    var size: String,
    @SerializedName("max_size")
    var max_size: String
)
package com.murbanob.melichallenge.data.api.entities

import com.google.gson.annotations.SerializedName

class ItemDetailPicturesApi(
    @SerializedName("id")
    var id: String,
    @SerializedName("secure_url")
    var secure_url: String,
)
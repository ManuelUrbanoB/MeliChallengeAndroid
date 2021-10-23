package com.murbanob.melichallenge.data.mappers.detail

import com.murbanob.melichallenge.data.api.entities.ItemDetailPicturesApi
import com.murbanob.melichallenge.domain.entities.ItemDetailPicture

object ItemDetailPictureMapper {

    fun convertApiToDomain(picturesApi: ItemDetailPicturesApi): ItemDetailPicture {
        return ItemDetailPicture(
            id = picturesApi.id,
            url = picturesApi.secure_url
        )
    }
}
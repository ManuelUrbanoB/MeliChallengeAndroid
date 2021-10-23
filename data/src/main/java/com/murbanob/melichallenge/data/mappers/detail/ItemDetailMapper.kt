package com.murbanob.melichallenge.data.mappers.detail

import com.murbanob.melichallenge.data.api.entities.ItemDetailResponseApi
import com.murbanob.melichallenge.domain.entities.ItemDetail

object ItemDetailMapper {

    fun apiToDomain(itemDetailResponseApi: ItemDetailResponseApi): ItemDetail {
        return ItemDetail(
            id = itemDetailResponseApi.id,
            title = itemDetailResponseApi.title,
            price = itemDetailResponseApi.price,
            currencyId = itemDetailResponseApi.currency_id,
            pictures = itemDetailResponseApi.pictures.map {
                ItemDetailPictureMapper.convertApiToDomain(it)
            }
        )
    }
}
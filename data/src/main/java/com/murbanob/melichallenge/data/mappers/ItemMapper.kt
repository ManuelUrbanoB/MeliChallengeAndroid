package com.murbanob.melichallenge.data.mappers

import com.murbanob.melichallenge.data.api.entities.ItemResponseApi
import com.murbanob.melichallenge.domain.entities.Item

object ItemMapper {

    fun apiToDomain(itemResponseApi: ItemResponseApi): Item {
        return Item(
            id = itemResponseApi.id,
            title = itemResponseApi.title,
            price = itemResponseApi.price,
            permalink = itemResponseApi.permalink,
            thumbnail = itemResponseApi.thumbnail,
            sold_quantity = itemResponseApi.sold_quantity
        )
    }
}
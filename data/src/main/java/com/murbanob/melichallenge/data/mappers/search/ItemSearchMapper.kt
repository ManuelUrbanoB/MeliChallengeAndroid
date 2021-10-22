package com.murbanob.melichallenge.data.mappers.search

import com.murbanob.melichallenge.data.api.entities.ItemSearchResponseApi
import com.murbanob.melichallenge.data.api.entities.SearchResponseApi
import com.murbanob.melichallenge.domain.entities.ItemSearch

object ItemSearchMapper {

    fun apiToDomain(searchResponseApi: ItemSearchResponseApi): ItemSearch {
        return ItemSearch(
            id = searchResponseApi.id,
            title = searchResponseApi.title,
            price = searchResponseApi.price,
            permalink = searchResponseApi.permalink,
            thumbnail = searchResponseApi.thumbnail,
            soldQuantity = searchResponseApi.sold_quantity,
            currencyId = searchResponseApi.currency_id
        )
    }
}
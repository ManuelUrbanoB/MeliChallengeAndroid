package com.murbanob.melichallenge.data.mappers

import com.murbanob.melichallenge.data.api.entities.ItemSearchResponseApi
import com.murbanob.melichallenge.domain.entities.ItemSearchResponse

object ItemResponseMapper {

    fun apiToDomain(itemSearchResponseApi: ItemSearchResponseApi): ItemSearchResponse {
        return ItemSearchResponse(
            items = itemSearchResponseApi.results.map { ItemMapper.apiToDomain(it) }
        )
    }
}
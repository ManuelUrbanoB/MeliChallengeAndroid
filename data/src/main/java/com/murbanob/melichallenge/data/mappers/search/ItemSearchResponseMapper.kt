package com.murbanob.melichallenge.data.mappers.search

import com.murbanob.melichallenge.data.api.entities.SearchResponseApi
import com.murbanob.melichallenge.domain.entities.ItemSearchResponse

object ItemSearchResponseMapper {

    fun apiToDomain(searchResponseApi: SearchResponseApi): ItemSearchResponse {
        return ItemSearchResponse(
            itemSearches = searchResponseApi.results.map { ItemSearchMapper.apiToDomain(it) }
        )
    }
}
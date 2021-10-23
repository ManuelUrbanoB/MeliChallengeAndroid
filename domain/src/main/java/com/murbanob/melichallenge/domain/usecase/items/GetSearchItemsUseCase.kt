package com.murbanob.melichallenge.domain.usecase.items

import com.murbanob.melichallenge.domain.entities.ItemSearchResponse
import com.murbanob.melichallenge.domain.helpers.Result
import com.murbanob.melichallenge.domain.usecase.BaseUseCase

interface GetSearchItemsUseCase : BaseUseCase {
    suspend fun getSearchItems(value: String): Result<ItemSearchResponse>
}
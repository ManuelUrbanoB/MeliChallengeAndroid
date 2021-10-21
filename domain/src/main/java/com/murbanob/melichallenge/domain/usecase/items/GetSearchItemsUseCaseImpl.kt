package com.murbanob.melichallenge.domain.usecase.items

import com.murbanob.melichallenge.domain.entities.ItemSearchResponse
import com.murbanob.melichallenge.domain.helpers.Result
import com.murbanob.melichallenge.domain.repository.items.ItemRepository

class GetSearchItemsUseCaseImpl(private val itemRepository: ItemRepository) :
    GetSearchItemsUseCase {
    override suspend fun getSearchItems(value: String): Result<ItemSearchResponse> {
        return itemRepository.getSearchItems(value)
    }
}
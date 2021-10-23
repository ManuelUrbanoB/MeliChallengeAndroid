package com.murbanob.melichallenge.domain.usecase.items

import com.murbanob.melichallenge.domain.entities.ItemDetail
import com.murbanob.melichallenge.domain.helpers.Result
import com.murbanob.melichallenge.domain.repository.items.ItemRepository

class GetItemDetailUseCaseImpl(private val itemRepository: ItemRepository): GetItemDetailUseCase {
    override suspend fun getItemDetail(id: String): Result<ItemDetail> {
        return itemRepository.getItemDetail(id)
    }
}
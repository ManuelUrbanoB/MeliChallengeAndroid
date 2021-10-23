package com.murbanob.melichallenge.domain.usecase.items

import com.murbanob.melichallenge.domain.entities.ItemDetail
import com.murbanob.melichallenge.domain.helpers.Result
import com.murbanob.melichallenge.domain.usecase.BaseUseCase

interface GetItemDetailUseCase: BaseUseCase {
    suspend fun getItemDetail(id: String): Result<ItemDetail>
}
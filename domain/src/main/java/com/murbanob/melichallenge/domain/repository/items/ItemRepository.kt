package com.murbanob.melichallenge.domain.repository.items

import com.murbanob.melichallenge.domain.entities.ItemDetail
import com.murbanob.melichallenge.domain.entities.ItemSearchResponse
import com.murbanob.melichallenge.domain.repository.BaseRepository
import com.murbanob.melichallenge.domain.helpers.Result

interface ItemRepository : BaseRepository {
    suspend fun getSearchItems(value: String): Result<ItemSearchResponse>
    suspend fun  getItemDetail(id: String): Result<ItemDetail>
}
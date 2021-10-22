package com.murbanob.melichallenge.data.datasource.remote

import com.murbanob.melichallenge.data.api.entities.ItemDetailResponseApi
import com.murbanob.melichallenge.data.api.entities.SearchResponseApi
import com.murbanob.melichallenge.domain.helpers.Result

interface ItemRemoteDataSource {
    suspend fun getSearchItems(value: String): Result<SearchResponseApi>
    suspend fun getItemDetail(id: String): Result<ItemDetailResponseApi>
}
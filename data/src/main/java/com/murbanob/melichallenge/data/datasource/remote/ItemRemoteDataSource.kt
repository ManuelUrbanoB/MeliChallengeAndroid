package com.murbanob.melichallenge.data.datasource.remote

import com.murbanob.melichallenge.data.api.entities.ItemSearchResponseApi
import com.murbanob.melichallenge.domain.helpers.Result

interface ItemRemoteDataSource {
    suspend fun getSearchItems(value: String): Result<ItemSearchResponseApi>
}
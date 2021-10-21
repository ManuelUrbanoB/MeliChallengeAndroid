package com.murbanob.melichallenge.data.datasource.remote

import com.murbanob.melichallenge.data.api.entities.ItemSearchResponseApi
import com.murbanob.melichallenge.data.api.items.ItemApi
import com.murbanob.melichallenge.domain.helpers.Result

class ItemRemoteDataSourceImpl(private val itemApi: ItemApi) : ItemRemoteDataSource {
    override suspend fun getSearchItems(value: String): Result<ItemSearchResponseApi> {
        val response = itemApi.getSearchItems(value)
        return when {
            response.isSuccessful -> {
                val body = response.body()
                if (body != null) {
                    Result.Success(body)
                } else {
                    Result.Error(Exception(""))
                }
            }
            else -> {
                Result.Error(Exception(""))
            }
        }
    }
}
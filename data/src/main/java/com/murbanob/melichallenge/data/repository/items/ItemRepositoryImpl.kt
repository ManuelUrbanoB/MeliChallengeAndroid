package com.murbanob.melichallenge.data.repository.items

import com.murbanob.melichallenge.data.datasource.remote.ItemRemoteDataSource
import com.murbanob.melichallenge.data.mappers.ItemResponseMapper
import com.murbanob.melichallenge.domain.entities.ItemSearchResponse
import com.murbanob.melichallenge.domain.repository.items.ItemRepository
import com.murbanob.melichallenge.domain.helpers.Result

class ItemRepositoryImpl(private val itemRemoteDataSource: ItemRemoteDataSource) : ItemRepository {
    override suspend fun getSearchItems(value: String): Result<ItemSearchResponse> {
        return when (val result = itemRemoteDataSource.getSearchItems(value)) {
            is Result.Success -> {
                Result.Success(ItemResponseMapper.apiToDomain(result.data))
            }
            is Result.Error -> {
                Result.Error(Exception(""))
            }
        }
    }
}
package com.murbanob.melichallenge.data.repository.items

import com.murbanob.melichallenge.data.datasource.remote.ItemRemoteDataSource
import com.murbanob.melichallenge.data.mappers.detail.ItemDetailMapper
import com.murbanob.melichallenge.data.mappers.detail.ItemDetailPictureMapper
import com.murbanob.melichallenge.data.mappers.search.ItemSearchResponseMapper
import com.murbanob.melichallenge.domain.entities.ItemDetail
import com.murbanob.melichallenge.domain.entities.ItemSearchResponse
import com.murbanob.melichallenge.domain.repository.items.ItemRepository
import com.murbanob.melichallenge.domain.helpers.Result

class ItemRepositoryImpl(private val itemRemoteDataSource: ItemRemoteDataSource) : ItemRepository {
    override suspend fun getSearchItems(value: String): Result<ItemSearchResponse> {
        return when (val result = itemRemoteDataSource.getSearchItems(value)) {
            is Result.Success -> {
                Result.Success(ItemSearchResponseMapper.apiToDomain(result.data))
            }
            is Result.Error -> result
        }
    }

    override suspend fun getItemDetail(id: String): Result<ItemDetail> {
        return when (val result = itemRemoteDataSource.getItemDetail(id)) {
            is Result.Success -> {
                Result.Success(ItemDetailMapper.apiToDomain(result.data))
            }
            is Result.Error -> result
        }
    }
}
package com.murbanob.melichallenge.data.datasource.remote

import com.murbanob.melichallenge.data.api.entities.ItemSearchResponseApi
import com.murbanob.melichallenge.data.api.items.ItemApi
import com.murbanob.melichallenge.domain.helpers.ErrorResult
import com.murbanob.melichallenge.domain.helpers.Result
import java.io.IOException

class ItemRemoteDataSourceImpl(private val itemApi: ItemApi) : ItemRemoteDataSource {
    override suspend fun getSearchItems(value: String): Result<ItemSearchResponseApi> {
        try {
            val response = itemApi.getSearchItems(value)
            return when {
                response.isSuccessful -> {
                    val body = response.body()
                    if (body != null) {
                        Result.Success(body)
                    } else {
                        Result.Error(ErrorResult.ErrorInResponse.getException())
                    }
                }
                else -> {
                    Result.Error(ErrorResult.ErrorInRequest.getException())
                }
            }
        } catch (exception: IOException) {
            return Result.Error(ErrorResult.ErrorInNetwork.getException())
        } catch (exception: Exception) {
            return Result.Error(ErrorResult.UnknownError.getException())
        }
    }
}
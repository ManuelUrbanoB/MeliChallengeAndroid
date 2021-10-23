package com.murbanob.melichallenge.data.datasource.remote

import com.murbanob.melichallenge.data.api.entities.ItemDetailResponseApi
import com.murbanob.melichallenge.data.api.entities.SearchResponseApi
import com.murbanob.melichallenge.data.api.items.ItemApi
import com.murbanob.melichallenge.domain.helpers.ErrorResult
import com.murbanob.melichallenge.domain.helpers.Result
import java.io.IOException

class ItemRemoteDataSourceImpl(private val itemApi: ItemApi) : ItemRemoteDataSource {
    override suspend fun getSearchItems(value: String): Result<SearchResponseApi> {
        try {
            val response = itemApi.getSearchItems(value)
            return when {
                response.isSuccessful -> {
                    val body = response.body()
                    if (body != null) {
                        Result.Success(body)
                    } else Result.Error(ErrorResult.ErrorInResponse.getException())
                }
                else -> Result.Error(ErrorResult.ErrorInRequest.getException())
            }
        } catch (exception: IOException) {
            return Result.Error(ErrorResult.ErrorInNetwork.getException())
        } catch (exception: Exception) {
            return Result.Error(ErrorResult.UnknownError.getException())
        }
    }

    override suspend fun getItemDetail(id: String): Result<ItemDetailResponseApi> {
        try {
            val response = itemApi.getItemDetail(id)
            return when {
                response.isSuccessful -> {
                    val body = response.body()
                    if (body != null) {
                        Result.Success(body)
                    } else Result.Error(ErrorResult.ErrorInResponse.getException())
                }
                else -> Result.Error(ErrorResult.ErrorInRequest.getException())
            }
        } catch (exception: IOException) {
            return Result.Error(ErrorResult.ErrorInNetwork.getException())
        } catch (exception: Exception) {
            return Result.Error(ErrorResult.UnknownError.getException())
        }
    }
}
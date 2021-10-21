package com.murbanob.melichallenge.data.api.items

import com.murbanob.melichallenge.data.api.entities.ItemSearchResponseApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ItemApi {
    @GET("sites/MLA/search")
    suspend fun getSearchItems(@Query("q") value: String): Response<ItemSearchResponseApi>
}
package com.murbanob.melichallenge.data.api.items

import com.murbanob.melichallenge.data.api.entities.ItemDetailResponseApi
import com.murbanob.melichallenge.data.api.entities.SearchResponseApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ItemApi {
    @GET("sites/MLA/search")
    suspend fun getSearchItems(@Query("q") value: String): Response<SearchResponseApi>

    @GET("/items/{productId}")
    suspend fun getItemDetail(@Path("productId") productId: String): Response<ItemDetailResponseApi>
}
package com.murbanob.melichallenge.data.repository.items

import com.murbanob.melichallenge.data.datasource.remote.ItemRemoteDataSource
import com.murbanob.melichallenge.data.mappers.detail.ItemDetailMapper
import com.murbanob.melichallenge.data.mappers.search.ItemSearchResponseMapper
import com.murbanob.melichallenge.domain.helpers.ErrorResult
import com.murbanob.melichallenge.domain.helpers.Result
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class ItemRepositoryImplTest {

    private val itemDataSource: ItemRemoteDataSource = mockk()
    private val itemRepositoryImpl = ItemRepositoryImpl(itemDataSource)

    @BeforeEach
    fun setUp() {
        clearAllMocks()
    }

    @Test
    fun testGetSearchItemsResponseSuccess() {
        coEvery { itemDataSource.getSearchItems(any()) } returns Result.Success(mockk(relaxed = true))
        mockkObject(ItemSearchResponseMapper)
        every { ItemSearchResponseMapper.apiToDomain(any()) } returns mockk(relaxed = true)
        runBlocking {
            val response = itemRepositoryImpl.getSearchItems("Book")
            Assert.assertTrue(response is Result.Success)
        }
        coVerify { itemDataSource.getSearchItems("Book") }
    }

    @Test
    fun testGetSearchItemsResponseError() {
        coEvery { itemDataSource.getSearchItems(any()) } returns Result.Error(ErrorResult.UnknownError.getException())
        mockkObject(ItemSearchResponseMapper)
        every { ItemSearchResponseMapper.apiToDomain(any()) } returns mockk(relaxed = true)
        runBlocking {
            val response = itemRepositoryImpl.getSearchItems("Book")
            Assert.assertTrue(response is Result.Error)
        }
        coVerify { itemDataSource.getSearchItems("Book") }
    }

    @Test
    fun testGetItemDetailResponseSuccess() {
        coEvery { itemDataSource.getItemDetail(any()) } returns Result.Success(mockk(relaxed = true))
        mockkObject(ItemDetailMapper)
        every { ItemDetailMapper.apiToDomain(any()) } returns mockk(relaxed = true)
        runBlocking {
            val response = itemRepositoryImpl.getItemDetail("Book")
            Assert.assertTrue(response is Result.Success)
        }
        coVerify { itemDataSource.getItemDetail("Book") }
    }

    @Test
    fun testGetItemDetailResponseError() {
        coEvery { itemDataSource.getItemDetail(any()) } returns Result.Error(ErrorResult.UnknownError.getException())
        mockkObject(ItemDetailMapper)
        every { ItemDetailMapper.apiToDomain(any()) } returns mockk(relaxed = true)
        runBlocking {
            val response = itemRepositoryImpl.getItemDetail("Book")
            Assert.assertTrue(response is Result.Error)
        }
        coVerify { itemDataSource.getItemDetail("Book") }
    }


}
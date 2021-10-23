package com.murbanob.melichallenge.data.datasource.remote

import com.murbanob.melichallenge.data.api.items.ItemApi
import com.murbanob.melichallenge.domain.helpers.ErrorResult
import com.murbanob.melichallenge.domain.helpers.Result
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import retrofit2.Response
import java.io.IOException


internal class ItemRemoteDataSourceImplTest {

    private val itemApi: ItemApi = mockk()
    private val itemRemoteDataSourceImpl = ItemRemoteDataSourceImpl(itemApi)

    @BeforeEach
    fun setUp() {
        clearAllMocks()
    }

    @Test
    fun testGetSearchItemsResponseSuccess() {
        coEvery { itemApi.getSearchItems(any()) } returns Response.success(mockk(relaxed = true))
        runBlocking {
            val result = itemRemoteDataSourceImpl.getSearchItems("Book")
            Assert.assertTrue(result is Result.Success)
        }
        coVerify { itemApi.getSearchItems("Book") }
    }

    @Test
    fun testGetSearchItemsErrorInResponse() {
        coEvery { itemApi.getSearchItems(any()) } returns Response.success(null)
        runBlocking {
            val result = itemRemoteDataSourceImpl.getSearchItems("Book")
            val exceptionMessageExcepted = ErrorResult.ErrorInResponse.getException().message
            val exceptionMessageResult = (result as Result.Error).exception.message
            Assert.assertEquals(exceptionMessageResult, exceptionMessageExcepted)
        }
        coVerify { itemApi.getSearchItems("Book") }
    }

    @Test
    fun testGetSearchItemsErrorInRequest() {
        coEvery { itemApi.getSearchItems(any()) } returns Response.error(
            505,
            ResponseBody.create(null, "")
        )
        runBlocking {
            val result = itemRemoteDataSourceImpl.getSearchItems("Book")
            Assert.assertTrue(result is Result.Error)
            val exceptionMessageExcepted = ErrorResult.ErrorInRequest.getException().message
            val exceptionMessageResult = (result as Result.Error).exception.message
            Assert.assertEquals(exceptionMessageResult, exceptionMessageExcepted)
        }
        coVerify { itemApi.getSearchItems("Book") }
    }

    @Test
    fun testGetSearchItemsNetworkError() {
        coEvery { itemApi.getSearchItems(any()) } throws IOException("NetworkError")
        runBlocking {
            val result = itemRemoteDataSourceImpl.getSearchItems("Book")
            Assert.assertTrue(result is Result.Error)
            val exceptionMessageExcepted = ErrorResult.ErrorInNetwork.getException().message
            val exceptionMessageResult = (result as Result.Error).exception.message
            Assert.assertEquals(exceptionMessageResult, exceptionMessageExcepted)
        }
        coVerify { itemApi.getSearchItems("Book") }
    }

    @Test
    fun testGetSearchItemsUnknownError() {
        coEvery { itemApi.getSearchItems(any()) } throws Exception("UnknownError")
        runBlocking {
            val result = itemRemoteDataSourceImpl.getSearchItems("Book")
            Assert.assertTrue(result is Result.Error)
            val exceptionMessageExcepted = ErrorResult.UnknownError.getException().message
            val exceptionMessageResult = (result as Result.Error).exception.message
            Assert.assertEquals(exceptionMessageResult, exceptionMessageExcepted)
        }
        coVerify { itemApi.getSearchItems("Book") }
    }

    @Test
    fun testGetItemDetailResponseSuccess() {
        coEvery { itemApi.getItemDetail(any()) } returns Response.success(mockk(relaxed = true))
        runBlocking {
            val result = itemRemoteDataSourceImpl.getItemDetail("id")
            Assert.assertTrue(result is Result.Success)
        }
        coVerify { itemApi.getItemDetail("id") }
    }

    @Test
    fun testGetItemDetailErrorInResponse() {
        coEvery { itemApi.getItemDetail(any()) } returns Response.success(null)
        runBlocking {
            val result = itemRemoteDataSourceImpl.getItemDetail("id")
            val exceptionMessageExcepted = ErrorResult.ErrorInResponse.getException().message
            val exceptionMessageResult = (result as Result.Error).exception.message
            Assert.assertEquals(exceptionMessageResult, exceptionMessageExcepted)
        }
        coVerify { itemApi.getItemDetail("id") }
    }

    @Test
    fun testGetItemDetailErrorInRequest() {
        coEvery { itemApi.getItemDetail(any()) } returns Response.error(
            505,
            ResponseBody.create(null, "")
        )
        runBlocking {
            val result = itemRemoteDataSourceImpl.getItemDetail("id")
            Assert.assertTrue(result is Result.Error)
            val exceptionMessageExcepted = ErrorResult.ErrorInRequest.getException().message
            val exceptionMessageResult = (result as Result.Error).exception.message
            Assert.assertEquals(exceptionMessageResult, exceptionMessageExcepted)
        }
        coVerify { itemApi.getItemDetail("id") }
    }

    @Test
    fun testGetItemDetailNetworkError() {
        coEvery { itemApi.getItemDetail(any()) } throws IOException("NetworkError")
        runBlocking {
            val result = itemRemoteDataSourceImpl.getItemDetail("id")
            Assert.assertTrue(result is Result.Error)
            val exceptionMessageExcepted = ErrorResult.ErrorInNetwork.getException().message
            val exceptionMessageResult = (result as Result.Error).exception.message
            Assert.assertEquals(exceptionMessageResult, exceptionMessageExcepted)
        }
        coVerify { itemApi.getItemDetail("id") }
    }

    @Test
    fun testGetItemDetailUnknownError() {
        coEvery { itemApi.getItemDetail(any()) } throws Exception("UnknownError")
        runBlocking {
            val result = itemRemoteDataSourceImpl.getItemDetail("id")
            Assert.assertTrue(result is Result.Error)
            val exceptionMessageExcepted = ErrorResult.UnknownError.getException().message
            val exceptionMessageResult = (result as Result.Error).exception.message
            Assert.assertEquals(exceptionMessageResult, exceptionMessageExcepted)
        }
        coVerify { itemApi.getItemDetail("id") }
    }

}
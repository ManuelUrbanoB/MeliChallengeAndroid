package com.murbanob.melichallenge.domain.usecase.items

import com.murbanob.melichallenge.domain.helpers.Result
import com.murbanob.melichallenge.domain.repository.items.ItemRepository
import io.mockk.clearMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GetSearchItemsUseCaseImplTest {

    private val itemRepository: ItemRepository = mockk()
    private val useCase: GetSearchItemsUseCaseImpl = GetSearchItemsUseCaseImpl(itemRepository)

    @BeforeEach
    fun setUp() {
        clearMocks()
    }

    @Test
    fun testGetSearchItems() {
        coEvery { itemRepository.getSearchItems(any()) } returns Result.Success(mockk())
        runBlocking {
            useCase.getSearchItems("value")
        }
        coVerify { itemRepository.getSearchItems("value") }
    }
}
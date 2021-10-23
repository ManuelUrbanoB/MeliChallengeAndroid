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

internal class GetItemDetailUseCaseImplTest {

    private val itemRepository: ItemRepository = mockk()
    private val useCase: GetItemDetailUseCaseImpl = GetItemDetailUseCaseImpl(itemRepository)

    @BeforeEach
    fun setUp() {
        clearMocks()
    }

    @Test
    fun testGetItemDetailUseCase() {
        coEvery { itemRepository.getItemDetail(any()) } returns Result.Success(mockk())
        runBlocking {
            useCase.getItemDetailUseCase("id")
        }
        coVerify { itemRepository.getItemDetail("id") }
    }
}
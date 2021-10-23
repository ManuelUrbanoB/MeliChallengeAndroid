package com.murbanob.melichallege.presentation.ui.main

import com.murbanob.melichallege.presentation.InstantExecutorExtension
import com.murbanob.melichallenge.domain.helpers.Result
import com.murbanob.melichallenge.domain.usecase.items.GetItemDetailUseCase
import com.murbanob.melichallenge.domain.usecase.items.GetSearchItemsUseCase
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith


@ExperimentalCoroutinesApi
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(InstantExecutorExtension::class)
internal class MainViewModelTest {

    private val dispatcher = TestCoroutineDispatcher()
    private val searchUseCase: GetSearchItemsUseCase = mockk()
    private val viewModel by lazy {
        MainViewModel(searchUseCase, dispatcher)
    }

    @BeforeEach
    fun setUp() {
        clearAllMocks()
        Dispatchers.setMain(dispatcher)
    }

    @Test
    fun getGetResultItemLiveData() = runBlockingTest {
        coEvery { searchUseCase.getSearchItems(any()) } returns Result.Success(mockk())
        viewModel.searchItems("value")
        val response = viewModel.getResultItemLiveData.value
        Assert.assertTrue(response is Result.Success)
        coVerify { searchUseCase.getSearchItems("value") }
    }
}
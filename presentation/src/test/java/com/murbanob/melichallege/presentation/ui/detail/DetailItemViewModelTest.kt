package com.murbanob.melichallege.presentation.ui.detail

import com.murbanob.melichallege.presentation.InstantExecutorExtension
import com.murbanob.melichallenge.domain.helpers.Result
import com.murbanob.melichallenge.domain.usecase.items.GetItemDetailUseCase
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
internal class DetailItemViewModelTest {

    private val dispatcher = TestCoroutineDispatcher()
    private val detailUseCase: GetItemDetailUseCase  = mockk()
    private val viewModel by lazy {
        DetailItemViewModel(detailUseCase, dispatcher)
    }

    @BeforeEach
    fun setUp() {
        clearAllMocks()
        Dispatchers.setMain(dispatcher)
    }

    @Test
    fun getGetItemDetailLiveData()  = runBlockingTest {
        coEvery { detailUseCase.getItemDetail(any()) } returns Result.Success(mockk())
        viewModel.getItemDetail("id")
        val response = viewModel.getItemDetailLiveData.value
        Assert.assertTrue(response is Result.Success)
        coVerify { detailUseCase.getItemDetail("id") }
    }
}
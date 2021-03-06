package com.murbanob.melichallege.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.murbanob.melichallenge.domain.entities.ItemSearchResponse
import com.murbanob.melichallenge.domain.helpers.Result
import com.murbanob.melichallenge.domain.usecase.items.GetSearchItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getSearchUseCase: GetSearchItemsUseCase,
    private val backgroundDispatcher: CoroutineDispatcher
) :
    ViewModel() {

    private var _getSearchMediator: MediatorLiveData<Result<ItemSearchResponse>> =
        MediatorLiveData()
    val getResultItemLiveData: LiveData<Result<ItemSearchResponse>> get() = _getSearchMediator

    fun searchItems(value: String) {
        viewModelScope.launch(backgroundDispatcher) {
            _getSearchMediator.postValue(getSearchUseCase.getSearchItems(value))
        }
    }
}
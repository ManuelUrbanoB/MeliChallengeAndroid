package com.murbanob.melichallege.presentation.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.murbanob.melichallenge.domain.entities.ItemDetail
import com.murbanob.melichallenge.domain.usecase.items.GetItemDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import com.murbanob.melichallenge.domain.helpers.Result
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailItemViewModel @Inject constructor(private val getItemDetailUseCase: GetItemDetailUseCase) :
    ViewModel() {

    private var _getItemDetailMediator: MediatorLiveData<Result<ItemDetail>> = MediatorLiveData()
    val getItemDetailLiveData: LiveData<Result<ItemDetail>> get() = _getItemDetailMediator

    fun getItemDetail(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _getItemDetailMediator.postValue(getItemDetailUseCase.getItemDetailUseCase(id))
        }
    }
}
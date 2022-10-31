package com.example.appproductptkb.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appproductptkb.data.network.response.ResponseDetail
import com.example.appproductptkb.domain.usecase.IProdukUseCase
import retrofit2.Response

class DetailViewModel(val useCase: IProdukUseCase) : ViewModel() {
    fun getData(id: String) : LiveData<ResponseDetail> = useCase.getDetail(id)
}
package com.example.appproductptkb.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.appproductptkb.data.network.response.DataItem
import com.example.appproductptkb.domain.model.ListProductModel
import com.example.appproductptkb.domain.usecase.IProdukUseCase

class MainViewModel(productUseCase: IProdukUseCase): ViewModel() {
    val product : LiveData<List<DataItem>> = productUseCase.getAllProduct()
}
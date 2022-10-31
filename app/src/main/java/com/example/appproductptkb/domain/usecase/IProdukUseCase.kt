package com.example.appproductptkb.domain.usecase

import androidx.lifecycle.LiveData
import com.example.appproductptkb.data.network.response.DataItem
import com.example.appproductptkb.domain.model.ListProductModel

interface IProdukUseCase {
    fun getAllProduct() : LiveData<List<DataItem>>
}
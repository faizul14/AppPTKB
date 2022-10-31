package com.example.appproductptkb.domain.usecase

import androidx.lifecycle.LiveData
import com.example.appproductptkb.data.network.response.DataItem
import com.example.appproductptkb.domain.model.ListProductModel
import com.example.appproductptkb.domain.repository.IProductRepository

class ProdukUseCaseIteractor(val repository: IProductRepository) : IProdukUseCase {
    override fun getAllProduct(): LiveData<List<DataItem>> {
        return repository.getAllProduct()
    }
}
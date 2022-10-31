package com.example.appproductptkb.domain.repository

import androidx.lifecycle.LiveData
import com.example.appproductptkb.data.network.response.DataItem
import com.example.appproductptkb.domain.model.ListProductModel

interface IProductRepository {
    fun getAllProduct() : LiveData<List<DataItem>>
}
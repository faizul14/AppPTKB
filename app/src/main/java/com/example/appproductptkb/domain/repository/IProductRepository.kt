package com.example.appproductptkb.domain.repository

import androidx.lifecycle.LiveData
import com.example.appproductptkb.data.network.response.DataItem
import com.example.appproductptkb.data.network.response.ResponseDetail
import com.example.appproductptkb.domain.model.ListProductModel
import retrofit2.Response

interface IProductRepository {
    fun getAllProduct() : LiveData<List<DataItem>>
    fun getDetail(id: String) : LiveData<ResponseDetail>
}
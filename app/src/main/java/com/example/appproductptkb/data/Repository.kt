package com.example.appproductptkb.data

import androidx.lifecycle.LiveData
import com.example.appproductptkb.data.network.RemoteDataSource
import com.example.appproductptkb.data.network.response.DataItem
import com.example.appproductptkb.data.network.response.ResponseDetail
import com.example.appproductptkb.domain.model.ListProductModel
import com.example.appproductptkb.domain.repository.IProductRepository
import com.example.appproductptkb.helper.DataMapper

class Repository(private val remoteDataSource: RemoteDataSource) : IProductRepository {

    companion object{
        @Volatile
        var INSTANCE: Repository? = null

        fun getInstance(remot: RemoteDataSource) : Repository =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: Repository(remot)
            }
    }

    override fun getAllProduct(): LiveData<List<DataItem>> {
        return remoteDataSource.getAllProduct()
    }

    override fun getDetail(id: String): LiveData<ResponseDetail> {
        return remoteDataSource.getDetail(id)
    }

}
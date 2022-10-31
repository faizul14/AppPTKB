package com.example.appproductptkb.data

import androidx.lifecycle.LiveData
import com.example.appproductptkb.data.network.RemoteDataSource
import com.example.appproductptkb.data.network.response.DataItem
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
//        return DataMapper.mapResponsesToDomain(remoteDataSource.getAllProduct() as List<DataItem>) as LiveData<List<ListProductModel>>
    }

//    override fun getAllProduct(): LiveData<List<ListProductModel>> {
//        val data: List<DataItem> = remoteDataSource.getAllProduct() as List<DataItem>
//        val _data = DataMapper.mapResponsesToDomain(data)
//        return _data as LiveData<List<ListProductModel>>
////        return DataMapper.mapResponsesToDomain(remoteDataSource.getAllProduct() as List<DataItem>) as LiveData<List<ListProductModel>>
//    }
}
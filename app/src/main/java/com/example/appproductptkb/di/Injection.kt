package com.example.appproductptkb.di

import com.example.appproductptkb.data.Repository
import com.example.appproductptkb.data.network.ApiConfig
import com.example.appproductptkb.data.network.RemoteDataSource
import com.example.appproductptkb.domain.repository.IProductRepository
import com.example.appproductptkb.domain.usecase.IProdukUseCase
import com.example.appproductptkb.domain.usecase.ProdukUseCaseIteractor

object Injection {
    private fun privideRepository() : IProductRepository{
        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        return Repository.getInstance(remoteDataSource)
    }

    fun provideUseCase() : IProdukUseCase{
        val repository = privideRepository()
        return ProdukUseCaseIteractor(repository)
    }

}
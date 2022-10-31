package com.example.appproductptkb.helper

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appproductptkb.di.Injection
import com.example.appproductptkb.domain.usecase.IProdukUseCase
import com.example.appproductptkb.presentation.detail.DetailViewModel
import com.example.appproductptkb.presentation.ui.MainViewModel

class ViewModelFactory(val productUseCase: IProdukUseCase) : ViewModelProvider.NewInstanceFactory() {
    companion object{
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getIntance() : ViewModelFactory =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: ViewModelFactory(Injection.provideUseCase())
            }
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(productUseCase) as T
        }
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(productUseCase) as T
        }
        throw IllegalAccessException("view model not found ${modelClass.name}")
    }
}
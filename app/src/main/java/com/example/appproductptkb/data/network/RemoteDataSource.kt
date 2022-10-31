package com.example.appproductptkb.data.network

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appproductptkb.data.network.response.DataItem
import com.example.appproductptkb.data.network.response.ResponseListProduct
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource (private val apiService: ApiService) {
    companion object{
        @Volatile
        var INSTANCE : RemoteDataSource? = null

        fun getInstance(service: ApiService) : RemoteDataSource =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: RemoteDataSource(service)
            }
    }

    @SuppressLint("CheckResult")
    fun getAllProduct() : LiveData<List<DataItem>>{
        val data = MutableLiveData<List<DataItem>>()

        val client = apiService.getListProduct()

        client.enqueue(object : Callback<ResponseListProduct>{
            override fun onResponse(
                call: Call<ResponseListProduct>,
                response: Response<ResponseListProduct>
            ) {
                val responseBody = response.body()
                if (responseBody != null && response.isSuccessful){
                    data.value = responseBody.data as List<DataItem>
                }else{
                    Log.d("APIRESPONSE", response.message())
                }
            }

            override fun onFailure(call: Call<ResponseListProduct>, t: Throwable) {
                Log.d("APIRESPONSE", t.message.toString())
            }

        })
        return data
    }
}
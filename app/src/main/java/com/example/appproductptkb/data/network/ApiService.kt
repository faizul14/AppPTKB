package com.example.appproductptkb.data.network

import com.example.appproductptkb.data.network.response.ResponseDetail
import com.example.appproductptkb.data.network.response.ResponseListProduct
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiService {
    @GET("android-ios/api/product")
    fun getListProduct() : Call <ResponseListProduct>

    @FormUrlEncoded
    @POST("android-ios/api/product")
    fun getById(
        @Field("id") id: String
    ) : Call <ResponseDetail>

}
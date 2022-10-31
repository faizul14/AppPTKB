package com.example.appproductptkb.helper

import androidx.lifecycle.LiveData
import com.example.appproductptkb.data.network.response.DataItem
import com.example.appproductptkb.domain.model.ListProductModel

object DataMapper {
        fun mapResponsesToDomain(input: List<DataItem>): List<ListProductModel> {
        val productList = ArrayList<ListProductModel>()
        input.map {
            val Product = ListProductModel(
                price = it.price,
                countRatingUser = it.countRatingUser,
                sellerName = it.sellerName,
                discount = it.discount,
                id = it.id,
                title = it.title,
                thumbnailImage = it.thumbnailImage,
                productRating = it.productRating,

            )
            productList.add(Product)
        }
        return productList
    }
}
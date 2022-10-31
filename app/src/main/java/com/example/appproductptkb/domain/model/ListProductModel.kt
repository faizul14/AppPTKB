package com.example.appproductptkb.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListProductModel(
    val price: Int? = null,
    val countRatingUser: Int? = null,
    val sellerName: String? = null,
    val discount: Int? = null,
    val id: String? = null,
    val title: String? = null,
    val thumbnailImage: String? = null,
    val productRating: Double? = null
) : Parcelable

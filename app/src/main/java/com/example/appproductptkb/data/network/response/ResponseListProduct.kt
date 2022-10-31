package com.example.appproductptkb.data.network.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class ResponseListProduct(

	@field:SerializedName("metadata")
	val metadata: Metadata? = null,

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("error")
	val error: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class Metadata(

	@field:SerializedName("per_page")
	val perPage: Int? = null,

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("page_count")
	val pageCount: Int? = null,

	@field:SerializedName("total_record")
	val totalRecord: Int? = null
)

@Parcelize
data class DataItem(

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("countRatingUser")
	val countRatingUser: Int? = null,

	@field:SerializedName("sellerName")
	val sellerName: String? = null,

	@field:SerializedName("discount")
	val discount: Int? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("thumbnailImage")
	val thumbnailImage: String? = null,

	@field:SerializedName("productRating")
	val productRating: Double? = null
): Parcelable

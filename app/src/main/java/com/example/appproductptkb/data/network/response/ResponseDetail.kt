package com.example.appproductptkb.data.network.response

import com.google.gson.annotations.SerializedName

data class ResponseDetail(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("error")
	val error: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class Data(

	@field:SerializedName("imageSlide")
	val imageSlide: List<String?>? = null,

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("descProduct")
	val descProduct: String? = null,

	@field:SerializedName("countRatingUser")
	val countRatingUser: Int? = null,

	@field:SerializedName("sellerName")
	val sellerName: String? = null,

	@field:SerializedName("discount")
	val discount: Int? = null,

	@field:SerializedName("comment")
	val comment: List<CommentItem?>? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("thumbnailImage")
	val thumbnailImage: String? = null,

	@field:SerializedName("productRating")
	val productRating: Double? = null
)

data class CommentItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("rating")
	val rating: Int? = null,

	@field:SerializedName("comment")
	val comment: String? = null
)

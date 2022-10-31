package com.example.appproductptkb.helper

object Discount {
    fun dc(price: Int, discount: Int): String {
        var result = 0.0
        if (discount != 0){
            var priceAfterDiscount : Double = ((discount.toDouble() /100.toDouble()) * price.toDouble())
            result = price.toDouble() - priceAfterDiscount
        }else{
            result = price.toDouble()
        }
        return FormatIDR.format(result.toInt())
    }
}
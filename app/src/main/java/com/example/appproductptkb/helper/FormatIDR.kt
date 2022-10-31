package com.example.appproductptkb.helper

import java.text.NumberFormat
import java.util.*

object FormatIDR {
    fun format(data: Int) : String{
        val local = Locale("in", "ID")
        val formatRP = NumberFormat.getCurrencyInstance(local)
        return formatRP.format(data)
    }
}
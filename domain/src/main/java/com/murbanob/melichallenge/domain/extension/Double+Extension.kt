package com.murbanob.melichallenge.domain.extension

import java.text.NumberFormat
import java.util.*

fun Double.getPriceFormat(currency: String): String {
    val format: NumberFormat = NumberFormat.getCurrencyInstance()
    format.maximumFractionDigits = 0
    format.currency = Currency.getInstance(currency)
    return format.format(this)
}
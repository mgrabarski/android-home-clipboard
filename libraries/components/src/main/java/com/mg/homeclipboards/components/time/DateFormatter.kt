package com.mg.homeclipboards.components.time

interface DateFormatter {
    fun detailsFormat(dateTime: Long): String
    fun shorterFormat(dateTime: Long): String
}
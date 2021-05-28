package com.mg.homeclipboards.domain.model

import org.joda.time.DateTime

data class CreateDate(
    val date: DateTime,
    val formattedDate: String
)
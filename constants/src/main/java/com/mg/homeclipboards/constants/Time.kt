package com.mg.homeclipboards.constants

import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter

val FORMAT_DETAILED_DATE: DateTimeFormatter = DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss")
val FORMAT_SHORTER_DATE: DateTimeFormatter = DateTimeFormat.forPattern("dd-MM-yyyy")
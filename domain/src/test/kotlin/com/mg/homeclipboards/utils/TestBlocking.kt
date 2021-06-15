package com.mg.homeclipboards.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking

fun testBlocking(testFunction: suspend CoroutineScope.() -> Unit) = runBlocking { testFunction() }
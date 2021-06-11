package com.mg.clipboards.test.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking

fun testBlocking(testFunction: suspend CoroutineScope.() -> Unit) = runBlocking { testFunction() }
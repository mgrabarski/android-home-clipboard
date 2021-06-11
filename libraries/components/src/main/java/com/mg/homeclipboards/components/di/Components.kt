package com.mg.homeclipboards.components.di

import com.mg.homeclipboards.components.dispatchers.DefaultDispatcherProvider
import com.mg.homeclipboards.components.dispatchers.DispatcherProvider
import com.mg.homeclipboards.components.time.DateFormatter
import com.mg.homeclipboards.components.time.TimeProvider
import com.mg.homeclipboards.components.time.impl.DateFormatterJodaTime
import com.mg.homeclipboards.components.time.impl.TimeProviderImpl
import com.mg.homeclipboards.constants.FORMAT_DETAILED_DATE
import com.mg.homeclipboards.constants.FORMAT_SHORTER_DATE
import org.koin.dsl.module

val libComponentsModule = module {
    factory<DateFormatter> { DateFormatterJodaTime(FORMAT_DETAILED_DATE, FORMAT_SHORTER_DATE) }
    factory<TimeProvider> { TimeProviderImpl(get()) }
    factory<DispatcherProvider> { DefaultDispatcherProvider() }
}
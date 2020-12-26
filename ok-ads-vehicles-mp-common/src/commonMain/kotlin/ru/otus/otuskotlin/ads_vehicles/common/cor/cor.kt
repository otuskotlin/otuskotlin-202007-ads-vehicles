package ru.otus.otuskotlin.ads_vehicles.common.cor

typealias CorMatcher<T> = suspend T.() -> Boolean
typealias CorHandler<T> = suspend T.() -> Unit
typealias CorErrorHandler<T> = suspend T.(Throwable) -> Unit

fun <T> corProcessor(block: Processor.Builder<T>.() -> Unit) = Processor.Builder<T>().apply(block).build()
fun <T> corHandler(block: Handler.Builder<T>.() -> Unit) = Handler.Builder<T>().apply(block).build()

package ru.otus.otuskotlin.ads_vehicles.backend

open class GenericError(
        override val code: String? = null,
        override val message: String? = null,
        override val originalException: Throwable? = null
) : IError {}
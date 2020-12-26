package ru.otus.otuskotlin.ads_vehicles.backend

class ValidationError(
        override val code: String? = null,
        override val message: String? = null,
        override val originalException: Throwable? = null
) : GenericError() {
}
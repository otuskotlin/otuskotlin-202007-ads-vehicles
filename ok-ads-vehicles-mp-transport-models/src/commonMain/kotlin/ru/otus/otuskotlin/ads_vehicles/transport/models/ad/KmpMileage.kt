package ru.otus.otuskotlin.ads_vehicles.transport.models.ad

import kotlinx.serialization.Serializable

@Serializable
data class KmpMileage(
        var value: Int? = null,
        var unit: String? = null
)
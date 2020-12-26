package ru.otus.otuskotlin.ads_vehicles.transport.models

import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.ads_vehicles.transport.models.vehicle.KmpMake

@Serializable
data class KmpMakeIndexResponse(
        val data: List<KmpMake>? = null,
        val limit: Int? = null,
        val offset: Int? = null
)
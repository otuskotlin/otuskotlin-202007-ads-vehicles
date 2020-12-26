package ru.otus.otuskotlin.ads_vehicles.transport.models

import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.ads_vehicles.transport.models.vehicle.KmpModel

@Serializable
data class KmpModelIndexResponse(
        val data: List<KmpModel>? = null,
        val limit: Int? = null,
        val offset: Int? = null
)
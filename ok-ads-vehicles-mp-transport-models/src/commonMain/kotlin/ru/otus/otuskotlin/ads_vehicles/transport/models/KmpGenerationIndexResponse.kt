package ru.otus.otuskotlin.ads_vehicles.transport.models

import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.ads_vehicles.transport.models.vehicle.KmpGeneration

@Serializable
data class KmpGenerationIndexResponse(
        val data: List<KmpGeneration>? = null,
        val limit: Int? = null,
        val offset: Int? = null
)
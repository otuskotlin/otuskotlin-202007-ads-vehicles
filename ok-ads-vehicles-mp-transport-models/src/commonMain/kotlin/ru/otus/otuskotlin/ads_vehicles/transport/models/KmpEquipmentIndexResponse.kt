package ru.otus.otuskotlin.ads_vehicles.transport.models

import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.ads_vehicles.transport.models.vehicle.KmpEquipment

@Serializable
data class KmpEquipmentIndexResponse(
        val data: List<KmpEquipment>? = null,
        val limit: Int? = null,
        val offset: Int? = null
)
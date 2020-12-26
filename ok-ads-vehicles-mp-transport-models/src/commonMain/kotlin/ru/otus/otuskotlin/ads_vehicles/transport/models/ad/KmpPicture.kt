package ru.otus.otuskotlin.ads_vehicles.transport.models.ad

import kotlinx.serialization.Serializable

@Serializable
data class KmpPicture(
        var id: String? = null,
        var path: String? = null
)
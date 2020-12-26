package ru.otus.otuskotlin.ads_vehicles.transport.models

import kotlinx.serialization.Serializable

@Serializable
data class KmpByIdQuery(
        var id: String? = null
) {
}
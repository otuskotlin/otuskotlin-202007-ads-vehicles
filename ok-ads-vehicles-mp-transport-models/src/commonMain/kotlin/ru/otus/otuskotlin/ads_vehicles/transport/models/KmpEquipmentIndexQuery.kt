package ru.otus.otuskotlin.ads_vehicles.transport.models

import kotlinx.serialization.Serializable

@Serializable
data class KmpEquipmentIndexQuery(
        var limit: Int? = null,
        var offset: Int? = null,
        var filter: Filter? = null
) {
    @Serializable
    data class Filter(
            var generationId: String? = null,
            var searchString: String? = null
    )
}
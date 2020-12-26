package ru.otus.otuskotlin.ads_vehicles.transport.models

import kotlinx.serialization.Serializable

@Serializable
data class KmpModelIndexQuery(
        var limit: Int? = null,
        var offset: Int? = null,
        var filter: Filter? = null
) {
    @Serializable
    data class Filter(
            var makeId: String? = null,
            var searchString: String? = null
    )
}
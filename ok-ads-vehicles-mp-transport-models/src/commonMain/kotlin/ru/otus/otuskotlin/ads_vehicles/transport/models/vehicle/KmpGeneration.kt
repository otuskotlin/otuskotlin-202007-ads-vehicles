package ru.otus.otuskotlin.ads_vehicles.transport.models.vehicle

import kotlinx.serialization.Serializable

@Serializable
data class KmpGeneration(
        /**
         * ID
         */
        var id: String? = null,

        /**
         * Model
         */
        var modelId: String? = null,

        /**
         * Name
         */
        var name: String? = null,

        /**
         * Production beginning year
         */
        var yearFrom: Int? = null,

        /**
         * Production ending year
         */
        var yearTo: Int? = null
)
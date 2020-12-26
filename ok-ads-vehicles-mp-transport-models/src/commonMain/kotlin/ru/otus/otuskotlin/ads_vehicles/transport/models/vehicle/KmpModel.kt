package ru.otus.otuskotlin.ads_vehicles.transport.models.vehicle

import kotlinx.serialization.Serializable

@Serializable
data class KmpModel(
        /**
         * ID
         */
        var id: String? = null,

        /**
         * Make
         */
        var makeId: String? = null,

        /**
         * Name
         */
        var name: String? = null        
)
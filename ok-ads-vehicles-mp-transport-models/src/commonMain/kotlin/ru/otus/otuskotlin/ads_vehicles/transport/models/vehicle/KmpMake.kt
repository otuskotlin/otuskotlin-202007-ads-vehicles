package ru.otus.otuskotlin.ads_vehicles.transport.models.vehicle

import kotlinx.serialization.Serializable

@Serializable
data class KmpMake(
        /**
         * ID
         */
        var id: String? = null,
        
        /**
         * Name
         */
        var name: String? = null,

        /**
         * ISO country code
         */
        var isoCountryCode: String? = null
)
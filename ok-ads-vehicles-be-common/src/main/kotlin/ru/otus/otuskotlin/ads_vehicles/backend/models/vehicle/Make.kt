package ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle

import ru.otus.otuskotlin.ads_vehicles.backend.models.IModel
import java.util.*

/**
 * Vehicle make
 */
data class Make (
        /**
         * ID
         */
        override var id: String? = null,

        /**
         * Name
         */
        val name: String? = null,

        /**
         * ISO country code
         */
        val isoCountryCode: String? = null
) : IModel {
    companion object {
        val NONE: Make = Make()
    }
}
package ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle

import ru.otus.otuskotlin.ads_vehicles.backend.models.IModel
import java.time.Year

/**
 * Vehicle model generation
 */
data class Generation(
        /**
         * ID
         */
        override var id: String? = null,

        /**
         * Model
         */
        val model: Model = Model.NONE,

        /**
         * Name
         */
        val name: String? = null,

        /**
         * Production beginning year
         */
        val yearFrom: Year? = null,

        /**
         * Production ending year
         */
        val yearTo: Year? = null
) : IModel {
    companion object {
        val NONE: Generation = Generation()
    }
}
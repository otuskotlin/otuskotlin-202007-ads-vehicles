package ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle

import ru.otus.otuskotlin.ads_vehicles.backend.models.IModel

/**
 * Vehicle model
 */
data class Model (
        /**
         * ID
         */
        override var id: String? = null,

        /**
         * Make
         */
        val make: Make = Make.NONE,

        /**
         * Name
         */
        val name: String? = null
) : IModel {
    companion object {
        val NONE: Model = Model()
    }
}
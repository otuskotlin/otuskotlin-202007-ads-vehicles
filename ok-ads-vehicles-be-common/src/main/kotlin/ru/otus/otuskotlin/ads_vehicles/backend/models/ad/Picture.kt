package ru.otus.otuskotlin.ads_vehicles.backend.models.ad

/**
 * Picture
 */
data class Picture (
        /**
         * ID
         */
        val id: String? = null,

        /**
         * Local storage file path
         */
        val path: String? = null,

        /**
         * Name
         */
        val name: String? = null
) {
    companion object {
        val NONE: Picture = Picture()
    }
}
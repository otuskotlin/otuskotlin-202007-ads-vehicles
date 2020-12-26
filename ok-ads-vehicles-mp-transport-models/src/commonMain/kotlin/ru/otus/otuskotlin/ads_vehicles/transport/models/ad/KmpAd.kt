package ru.otus.otuskotlin.ads_vehicles.transport.models.ad

import kotlinx.serialization.Serializable

@Serializable
data class KmpAd(
        /**
         * ID
         */
        var id: String? = null,

        /**
         * Vehicle production year
         */
        var year: Int? = null,

        /**
         * Vehicle mileage
         */
        var mileage: KmpMileage? = null,

        /**
         * Owners count
         */
        var owners: Int? = null,

        /**
         * Price
         */
        var price: KmpMoneyAmount? = null,

        /**
         * VIN
         */
        var vin: String? = null,

        /**
         * License plate
         */
        var licensePlate: String? = null,

        /**
         * Vehicle colour, RGB
         */
        var colour: Int? = null,

        /**
         * Make
         */
        var makeId: String? = null,

        /**
         * Model
         */
        var modelId: String? = null,

        /**
         * Generation
         */
        var generationId: String? = null,

        /**
         * Equipment
         */
        val equipmentId: String? = null,

        /**
         * Repair requirement flag
         */
        val needsRepair: Boolean? = null,

        /**
         * Vehicle pictures
         */
        val pictureIds: List<String>? = null,

        /**
         * User-defined vehicle description
         */
        val description: String? = null,

        /**
         * User
         */
        val userId: String? = null,

        /**
         * Ad date
         */
        val date: String? = null,

        /**
         * Activity flag
         */
        val isActive: Boolean? = null
) {
}
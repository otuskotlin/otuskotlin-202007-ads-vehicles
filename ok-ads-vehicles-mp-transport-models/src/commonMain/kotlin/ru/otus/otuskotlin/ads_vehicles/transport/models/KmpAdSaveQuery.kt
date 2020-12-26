package ru.otus.otuskotlin.ads_vehicles.transport.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import ru.otus.otuskotlin.ads_vehicles.transport.models.ad.KmpMileage
import ru.otus.otuskotlin.ads_vehicles.transport.models.ad.KmpMoneyAmount

@Serializable
abstract class KmpAdSaveQuery(
        /**
         * Vehicle production year
         */
        @Transient open var year: Int? = null,

        /**
         * Vehicle mileage
         */
        @Transient open var mileage: KmpMileage? = null,

        /**
         * Owners count
         */
        @Transient open var owners: Int? = null,

        /**
         * Price
         */
        @Transient open var price: KmpMoneyAmount? = null,

        /**
         * VIN
         */
        @Transient open var vin: String? = null,

        /**
         * License plate
         */
        @Transient open var licensePlate: String? = null,

        /**
         * Vehicle colour, RGB
         */
        @Transient open var colour: Int? = null,

        /**
         * Make
         */
        @Transient open var makeId: String? = null,

        /**
         * Model
         */
        @Transient open var modelId: String? = null,

        /**
         * Generation
         */
        @Transient open var generationId: String? = null,

        /**
         * Equipment
         */
        @Transient open var equipmentId: String? = null,

        /**
         * Repair requirement flag
         */
        @Transient open var needsRepair: Boolean? = null,

        /**
         * Vehicle pictures, list of Base64-encoded files
         */
        @Transient open var pictures: List<String>? = null,

        /**
         * User-defined vehicle description
         */
        @Transient open var description: String? = null,

        /**
         * User
         */
        @Transient open var userId: String? = null
)
package ru.otus.otuskotlin.ads_vehicles.transport.models.vehicle

import kotlinx.serialization.Serializable

@Serializable
data class KmpEquipment(
        /**
         * ID
         */
        var id: String? = null,

        /**
         * Generation
         */
        var generationId: String? = null,

        /**
         * Equipment name
         */
        var name: String? = null,

        /**
         * Engine type
         */
        var engineType: String? = null,

        /**
         * Engine layout
         */
        var engineLayout: String? = null,

        /**
         * Engine boost type
         */
        var boostType: String? = null,

        /**
         * Engine volume, CC
         */
        var engineCC: Int? = null,

        /**
         * Engine cylinder layout
         */
        var engineCylinderLayout: String? = null,

        /**
         * Engine cylinders count
         */
        var engineCylinders: Int? = null,

        /**
         * Engine power, HP
         */
        var enginePowerHP: Int? = null,

        /**
         * Gearbox type
         */
        var gearboxType: String? = null,

        /**
         * Gears count
         */
        var gears: Int? = null,

        /**
         * Drive type
         */
        var driveType: String? = null,

        /**
         * Steering wheel disposition
         */
        var steeringWheel: String? = null,

        /**
         * Chassis type
         */
        var chassisType: String? = null
)
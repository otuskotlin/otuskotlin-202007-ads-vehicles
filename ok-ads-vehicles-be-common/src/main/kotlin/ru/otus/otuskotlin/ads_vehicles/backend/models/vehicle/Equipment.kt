package ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle

import ru.otus.otuskotlin.ads_vehicles.backend.models.IModel
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.enums.*

/**
 * Vehicle equipment
 */
data class Equipment(
        /**
         * ID
         */
        override var id: String? = null,

        /**
         * Generation
         */
        val generation: Generation = Generation.NONE,

        /**
         * Equipment name
         */
        val name: String? = null,

        /**
         * Engine type
         */
        val engineType: EngineType? = null,

        /**
         * Engine layout
         */
        val engineLayout: EngineLayout? = null,

        /**
         * Engine boost type
         */
        val boostType: BoostType? = null,

        /**
         * Engine volume, CC
         */
        val engineCC: Int? = null,

        /**
         * Engine cylinder layout
         */
        val engineCylinderLayout: EngineCylinderLayout? = null,

        /**
         * Engine cylinders count
         */
        val engineCylinders: Int? = null,

        /**
         * Engine power, HP
         */
        val enginePowerHP: Int? = null,

        /**
         * Gearbox type
         */
        val gearboxType: GearboxType? = null,

        /**
         * Gears count
         */
        val gears: Int? = null,

        /**
         * Drive type
         */
        val driveType: DriveType? = null,

        /**
         * Steering wheel disposition
         */
        val steeringWheel: SteeringWheel? = null,

        /**
         * Chassis type
         */
        val chassisType: ChassisType? = null
) : IModel {
    companion object {
        val NONE: Equipment = Equipment()
    }
}
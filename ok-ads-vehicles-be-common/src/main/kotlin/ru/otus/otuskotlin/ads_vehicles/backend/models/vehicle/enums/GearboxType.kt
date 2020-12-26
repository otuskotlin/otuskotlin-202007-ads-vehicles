package ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.enums

/**
 * Gearbox type
 */
enum class GearboxType {
    /**
     * Manual
     */
    MANUAL,

    /**
     * Classic automatic
     */
    AUTO,

    /**
     * Robotic
     */
    ROBOT,

    /**
     * Dual-clutch transmission
     */
    DCT,

    /**
     * Continuously variable transmission
     */
    CVT,

    /**
     * Direct drive
     */
    DIRECT;

    companion object {}
}
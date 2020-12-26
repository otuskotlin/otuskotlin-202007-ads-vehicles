package ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.enums

/**
 * Drive type
 */
enum class DriveType {
    /**
     * Rear wheel drive
     */
    RWD,

    /**
     * Front wheel drive
     */
    FWD,

    /**
     * Full-time all wheel drive
     */
    FULL_TIME_AWD,

    /**
     * Part-time all wheel drive
     */
    PART_TIME_AWD;

    companion object {}
}
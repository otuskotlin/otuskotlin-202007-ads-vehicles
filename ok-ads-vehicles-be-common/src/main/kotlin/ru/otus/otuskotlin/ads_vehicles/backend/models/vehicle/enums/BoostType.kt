package ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.enums

/**
 * Engine boost type
 */
enum class BoostType {
    /**
     * Naturally aspirated
     */
    NA,

    /**
     * Turbocharger
     */
    TURBO,

    /**
     * Supercharger
     */
    SUPERCHARGER;

    companion object {}
}
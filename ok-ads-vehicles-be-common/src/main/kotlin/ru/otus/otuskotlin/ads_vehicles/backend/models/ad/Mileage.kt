package ru.otus.otuskotlin.ads_vehicles.backend.models.ad

/**
 * Mileage
 */
data class Mileage(
        val value: Int? = null,
        val unit: MileageUnit? = null
) {
    companion object {
        val NONE: Mileage = Mileage()
    }

    enum class MileageUnit {
        KM,
        MI;

        companion object {
            val DEFAULT: MileageUnit = KM
        }
    }
}
package ru.otus.otuskotlin.ads_vehicles.backend.contexts

import ru.otus.otuskotlin.ads_vehicles.backend.models.ad.Ad
import ru.otus.otuskotlin.ads_vehicles.backend.models.ad.Mileage
import ru.otus.otuskotlin.ads_vehicles.backend.models.ad.MoneyAmount
import java.time.Year

data class AdContext(
        var requestAdId: String? = null,
        var requestAd: Ad? = null,
        var filter: Filter = Filter.NONE,
        var responseAd: Ad = Ad.NONE,
        var responseIndex: MutableList<Ad> = mutableListOf()
) : AbstractContext() {
    data class Filter(
            val makeId: String? = null,
            val modelId: String? = null,
            val generationId: String? = null,
            val equipmentId: String? = null,
            val yearFrom: Year? = null,
            val yearTo: Year? = null,
            val mileageFrom: Mileage? = null,
            val mileageTo: Mileage? = null,
            val priceFrom: MoneyAmount? = null,
            val priceTo: MoneyAmount? = null,
            val maxOwners: Int? = null,
            val noNeedForRepair: Boolean? = null,
            val withPictures: Boolean? = null
    ) {
        companion object {
            val NONE: Filter = Filter()
        }
    }
}
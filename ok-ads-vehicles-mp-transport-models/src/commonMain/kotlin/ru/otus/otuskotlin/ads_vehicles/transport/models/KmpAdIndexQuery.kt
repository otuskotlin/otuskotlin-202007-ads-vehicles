package ru.otus.otuskotlin.ads_vehicles.transport.models

import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.ads_vehicles.transport.models.ad.KmpMileage
import ru.otus.otuskotlin.ads_vehicles.transport.models.ad.KmpMoneyAmount

@Serializable
data class KmpAdIndexQuery(
        var limit: Int? = null,
        var offset: Int? = null,
        var sorting: Sorting? = null,
        var filter: Filter? = null
) {
    @Serializable
    data class Sorting(
            var by: String? = null,
            var order: String? = null
    )

    @Serializable
    data class Filter(
            var makeId: String? = null,
            var modelId: String? = null,
            var generationId: String? = null,
            var equipmentId: String? = null,
            var yearFrom: Int? = null,
            var yearTo: Int? = null,
            var mileageFrom: KmpMileage? = null,
            var mileageTo: KmpMileage? = null,
            var priceFrom: KmpMoneyAmount? = null,
            var priceTo: KmpMoneyAmount? = null,
            var maxOwners: Int? = null,
            var noNeedForRepair: Boolean? = null,
            var withPictures: Boolean? = null
    )
}
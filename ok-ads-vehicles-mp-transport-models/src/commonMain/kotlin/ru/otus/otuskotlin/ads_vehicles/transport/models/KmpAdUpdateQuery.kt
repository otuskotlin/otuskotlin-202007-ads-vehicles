package ru.otus.otuskotlin.ads_vehicles.transport.models

import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.ads_vehicles.transport.models.ad.KmpMileage
import ru.otus.otuskotlin.ads_vehicles.transport.models.ad.KmpMoneyAmount

@Serializable
data class KmpAdUpdateQuery(
        var id: String? = null,
        override var mileage: KmpMileage? = null,
        override var price: KmpMoneyAmount? = null,
        override var vin: String? = null,
        override var licensePlate: String? = null,
        override var needsRepair: Boolean? = null,
        override var pictures: List<String>? = null,
        override var description: String? = null
) : KmpAdSaveQuery(
        mileage = mileage,
        price = price,
        vin = vin,
        licensePlate = licensePlate,
        needsRepair = needsRepair,
        pictures = pictures,
        description = description
)
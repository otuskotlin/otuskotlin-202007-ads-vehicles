package ru.otus.otuskotlin.ads_vehicles.transport.models

import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.ads_vehicles.transport.models.ad.KmpMileage
import ru.otus.otuskotlin.ads_vehicles.transport.models.ad.KmpMoneyAmount

@Serializable
data class KmpAdCreateQuery(
        override var year: Int? = null,
        override var mileage: KmpMileage? = null,
        override var owners: Int? = null,
        override var price: KmpMoneyAmount? = null,
        override var vin: String? = null,
        override var licensePlate: String? = null,
        override var colour: Int? = null,
        override var makeId: String? = null,
        override var modelId: String? = null,
        override var generationId: String? = null,
        override var equipmentId: String? = null,
        override var needsRepair: Boolean? = null,
        override var pictures: List<String>? = null,
        override var description: String? = null,
        override var userId: String? = null
) : KmpAdSaveQuery(
        year = year,
        mileage = mileage,
        owners = owners,
        price = price,
        vin = vin,
        licensePlate = licensePlate,
        colour = colour,
        makeId = makeId,
        modelId = modelId,
        generationId = generationId,
        equipmentId = equipmentId,
        needsRepair = needsRepair,
        pictures = pictures,
        description = description,
        userId = userId
)
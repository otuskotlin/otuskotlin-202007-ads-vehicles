package ru.otus.otuskotlin.ads_vehicles.transport.models

import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.ads_vehicles.transport.models.ad.KmpPicture

@Serializable
data class KmpAdPicturesIndexResponse(
        val data: List<KmpPicture>? = null
)
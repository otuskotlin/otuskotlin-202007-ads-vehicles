package ru.otus.otuskotlin.ads_vehicles.transport.models

import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.ads_vehicles.transport.models.ad.KmpAd

@Serializable
data class KmpAdIndexResponse(
        val data: List<KmpAd>? = null,
        val limit: Int? = null,
        val offset: Int? = null
)
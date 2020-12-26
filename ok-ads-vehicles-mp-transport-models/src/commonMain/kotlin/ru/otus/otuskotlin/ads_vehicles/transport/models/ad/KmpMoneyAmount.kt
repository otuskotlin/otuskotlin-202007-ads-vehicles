package ru.otus.otuskotlin.ads_vehicles.transport.models.ad

import kotlinx.serialization.Serializable

@Serializable
data class KmpMoneyAmount(
        var amount: Int? = null,
        var currency: String? = null
)
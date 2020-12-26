package ru.otus.otuskotlin.ads_vehicles.backend.dsl.ad

import ru.otus.otuskotlin.ads_vehicles.backend.models.ad.Ad

@AdDslMarker
class AdDsl {
    public fun build(): Ad = Ad(

    )
}

fun ad(conf: AdDsl.() -> Unit) = AdDsl().apply(conf).build()
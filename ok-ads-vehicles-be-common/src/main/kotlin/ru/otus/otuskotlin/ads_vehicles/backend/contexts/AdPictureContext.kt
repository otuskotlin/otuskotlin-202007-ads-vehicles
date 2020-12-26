package ru.otus.otuskotlin.ads_vehicles.backend.contexts

import ru.otus.otuskotlin.ads_vehicles.backend.models.ad.Picture

data class AdPictureContext(
        var requestAdId: String? = null,
        var responseAdPictureIndex: MutableList<Picture> = mutableListOf()
) : AbstractContext() {
}
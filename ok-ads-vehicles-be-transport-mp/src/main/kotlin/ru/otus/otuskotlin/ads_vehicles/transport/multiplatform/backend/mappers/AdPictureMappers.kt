package ru.otus.otuskotlin.ads_vehicles.transport.multiplatform.backend.mappers

import ru.otus.otuskotlin.ads_vehicles.backend.contexts.AdPictureContext
import ru.otus.otuskotlin.ads_vehicles.backend.models.ad.Picture
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpAdPicturesIndexResponse
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpByIdQuery
import ru.otus.otuskotlin.ads_vehicles.transport.models.ad.KmpPicture

fun AdPictureContext.setQuery(query: KmpByIdQuery) = this.apply {
    this.requestAdId = query.id
}

fun AdPictureContext.resultIndex(): KmpAdPicturesIndexResponse = KmpAdPicturesIndexResponse(
        data = this.responseAdPictureIndex.map { it.kmp() }
)

fun Picture.kmp() = KmpPicture(
        id = this.id,
        path = this.path
)
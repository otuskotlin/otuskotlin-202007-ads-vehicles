package ru.otus.otuskotlin.ads_vehicles.transport.multiplatform.backend.mappers

import ru.otus.otuskotlin.ads_vehicles.backend.contexts.AbstractContext
import ru.otus.otuskotlin.ads_vehicles.backend.contexts.ModelContext
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Model
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpByIdQuery
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpModelIndexQuery
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpModelIndexResponse
import ru.otus.otuskotlin.ads_vehicles.transport.models.vehicle.KmpModel

fun ModelContext.setQuery(query: KmpByIdQuery) = this.apply {
    this.requestModelId = query.id
}

fun ModelContext.setQuery(query: KmpModelIndexQuery) = this.apply {
    if (query.limit != null || query.offset != null) {
        this.index = AbstractContext.Index(query.limit, query.offset)
    }

    this.filter = query.filter?.let {
        ModelContext.Filter(
                makeId = it.makeId,
                searchString = it.searchString
        )
    } ?: ModelContext.Filter.NONE
}

fun ModelContext.responseItem(): KmpModel = this.responseModel.kmp()

fun ModelContext.responseIndex(): KmpModelIndexResponse = KmpModelIndexResponse(
        data = this.responseModelIndex.map { it.kmp() },
        limit = this.index?.limit,
        offset = this.index?.offset
)

fun Model.kmp() = KmpModel(
        id = this.id,
        makeId = this.make.id,
        name = this.name
)
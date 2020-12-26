package ru.otus.otuskotlin.ads_vehicles.transport.multiplatform.backend.mappers

import ru.otus.otuskotlin.ads_vehicles.backend.contexts.AbstractContext
import ru.otus.otuskotlin.ads_vehicles.backend.contexts.MakeContext
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Make
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpByIdQuery
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpMakeIndexQuery
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpMakeIndexResponse
import ru.otus.otuskotlin.ads_vehicles.transport.models.vehicle.KmpMake
import java.util.*

fun MakeContext.setQuery(query: KmpByIdQuery) = this.apply {
    this.requestMakeId = query.id
}

fun MakeContext.setQuery(query: KmpMakeIndexQuery) = this.apply {
    if (query.limit != null || query.offset != null) {
        this.index = AbstractContext.Index(query.limit, query.offset)
    }

    this.filter = query.filter?.let { queryFilter: KmpMakeIndexQuery.Filter ->
        MakeContext.Filter(
                isoCountry = queryFilter.isoCountryCode,
                searchString = queryFilter.searchString
        )
    } ?: MakeContext.Filter.NONE
}

fun MakeContext.responseItem(): KmpMake = this.responseMake.kmp()

fun MakeContext.responseIndex(): KmpMakeIndexResponse = KmpMakeIndexResponse(
        data = this.responseMakeIndex.map { it.kmp() },
        limit = this.index?.limit,
        offset = this.index?.offset
)

fun Make.kmp() = KmpMake(
        id = this.id,
        name = this.name,
        isoCountryCode = this.isoCountryCode
)
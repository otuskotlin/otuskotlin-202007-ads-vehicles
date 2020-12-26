package ru.otus.otuskotlin.ads_vehicles.transport.multiplatform.backend.mappers

import ru.otus.otuskotlin.ads_vehicles.backend.contexts.AbstractContext
import ru.otus.otuskotlin.ads_vehicles.backend.contexts.GenerationContext
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Generation
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpByIdQuery
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpGenerationIndexQuery
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpGenerationIndexResponse
import ru.otus.otuskotlin.ads_vehicles.transport.models.vehicle.KmpGeneration

fun GenerationContext.setQuery(query: KmpByIdQuery) = this.apply {
    this.requestGenerationId = query.id
}

fun GenerationContext.setQuery(query: KmpGenerationIndexQuery) = this.apply {
    if (query.limit != null || query.offset != null) {
        this.index = AbstractContext.Index(query.limit, query.offset)
    }

    this.filter = query.filter?.let {
        GenerationContext.Filter(
                modelId = it.modelId,
                searchString = it.searchString
        )
    } ?: GenerationContext.Filter.NONE
}

fun GenerationContext.responseItem(): KmpGeneration = this.responseGeneration.kmp()

fun GenerationContext.responseIndex(): KmpGenerationIndexResponse = KmpGenerationIndexResponse(
        data = this.responseIndex.map { it.kmp() },
        limit = this.index?.limit,
        offset = this.index?.offset
)

fun Generation.kmp(): KmpGeneration = KmpGeneration(
        id = this.id,
        name = this.name,
        modelId = this.model.id
)
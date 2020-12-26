package ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.repositories

import org.cache2k.Cache
import ru.otus.otuskotlin.ads_vehicles.backend.contexts.ModelContext
import ru.otus.otuskotlin.ads_vehicles.backend.exceptions.ModelNotFound
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Model
import ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.buildCache
import ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.dto.ModelInmemoryDto
import ru.otus.otuskotlin.ads_vehicles.storage.common.repositories.IModelRepository
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class ModelRepoInmemory(
        ttl: Duration,
        initObjects: Collection<Model> = emptyList(),
        makeRepoInmemory: MakeRepoInmemory
) : IModelRepository, AbstractRepoInmemory<Model, ModelInmemoryDto, MakeRepoInmemory>(makeRepoInmemory) {
    override val cache: Cache<String, ModelInmemoryDto> = buildCache(ttl, initObjects, ModelInmemoryDto::of)

    override suspend fun get(id: String): Model {
        val dto: ModelInmemoryDto = cache.get(id) ?: throw ModelNotFound(id)
        return dto.model(this.parentRepo!!.get(dto.makeId!!))
    }

    override suspend fun index(filter: ModelContext.Filter): Collection<Model> = this.cache.asMap()
            .filter {
                filter.makeId?.let { makeId -> it.value.makeId!! == makeId } ?: true
            }
            .filter {
                filter.searchString?.let { searchString -> it.value.name?.contains(searchString, true) ?: true } ?: true
            }
            .map { it.value.model(this@ModelRepoInmemory.parentRepo!!.get(it.value.makeId!!)) }

    override suspend fun create(model: Model): Model {
        this.cache.put(model.id, ModelInmemoryDto.of(model))
        return this.cache.get(model.id).model(model.make)
    }
}
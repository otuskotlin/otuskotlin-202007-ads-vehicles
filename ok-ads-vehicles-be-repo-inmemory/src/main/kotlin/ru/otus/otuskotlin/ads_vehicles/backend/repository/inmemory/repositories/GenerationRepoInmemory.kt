package ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.repositories

import org.cache2k.Cache
import ru.otus.otuskotlin.ads_vehicles.backend.contexts.GenerationContext
import ru.otus.otuskotlin.ads_vehicles.backend.exceptions.GenerationNotFound
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Generation
import ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.buildCache
import ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.dto.GenerationInmemoryDto
import ru.otus.otuskotlin.ads_vehicles.storage.common.repositories.IGenerationRepository
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class GenerationRepoInmemory(
        ttl: Duration,
        initObjects: Collection<Generation> = emptyList(),
        modelRepoInmemory: ModelRepoInmemory
) : IGenerationRepository, AbstractRepoInmemory<Generation, GenerationInmemoryDto, ModelRepoInmemory>(modelRepoInmemory) {
    override val cache: Cache<String, GenerationInmemoryDto> = buildCache(ttl, initObjects, GenerationInmemoryDto::of)

    override suspend fun get(id: String): Generation {
        val dto: GenerationInmemoryDto = cache.get(id) ?: throw GenerationNotFound(id)
        return dto.model(this.parentRepo!!.get(dto.modelId!!))
    }

    override suspend fun index(filter: GenerationContext.Filter): Collection<Generation> = this.cache.asMap()
            .filter {
                filter.modelId?.let { modelId -> it.value.modelId!! == modelId } ?: true
            }
            .filter {
                filter.searchString?.let { searchString -> it.value.name?.contains(searchString, true) ?: true } ?: true
            }
            .map { it.value.model(this@GenerationRepoInmemory.parentRepo!!.get(it.value.modelId!!)) }

    override suspend fun create(generation: Generation): Generation {
        this.cache.put(generation.id, GenerationInmemoryDto.of(generation))
        return this.cache.get(generation.id).model(generation.model)
    }
}
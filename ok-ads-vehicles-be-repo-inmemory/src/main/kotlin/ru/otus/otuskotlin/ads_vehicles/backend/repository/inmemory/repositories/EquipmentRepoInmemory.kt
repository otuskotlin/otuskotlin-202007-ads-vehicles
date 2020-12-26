package ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.repositories

import org.cache2k.Cache
import ru.otus.otuskotlin.ads_vehicles.backend.contexts.EquipmentContext
import ru.otus.otuskotlin.ads_vehicles.backend.exceptions.EquipmentNotFound
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Equipment
import ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.buildCache
import ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.dto.EquipmentInmemoryDto
import ru.otus.otuskotlin.ads_vehicles.storage.common.repositories.IEquipmentRepository
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class EquipmentRepoInmemory(
        ttl: Duration,
        initObjects: Collection<Equipment> = emptyList(),
        generationRepository: GenerationRepoInmemory
) : IEquipmentRepository, AbstractRepoInmemory<Equipment, EquipmentInmemoryDto, GenerationRepoInmemory>(generationRepository) {
    override val cache: Cache<String, EquipmentInmemoryDto> = buildCache(ttl, initObjects, EquipmentInmemoryDto::of)

    override suspend fun get(id: String): Equipment {
        val dto: EquipmentInmemoryDto = cache.get(id) ?: throw EquipmentNotFound(id)
        return dto.model(this.parentRepo!!.get(dto.generationId!!))
    }

    override suspend fun index(filter: EquipmentContext.Filter): Collection<Equipment> = this.cache.asMap()
            .filter {
                filter.generationId?.let { generationId -> it.value.generationId!! == generationId } ?: true
            }
            .filter {
                filter.searchString?.let { searchString -> it.value.name?.contains(searchString, true) ?: true } ?: true
            }
            .map { it.value.model(this@EquipmentRepoInmemory.parentRepo!!.get(it.value.generationId!!)) }

    override suspend fun create(equipment: Equipment): Equipment {
        this.cache.put(equipment.id, EquipmentInmemoryDto.of(equipment))
        return this.cache.get(equipment.id).model(equipment.generation)
    }
}
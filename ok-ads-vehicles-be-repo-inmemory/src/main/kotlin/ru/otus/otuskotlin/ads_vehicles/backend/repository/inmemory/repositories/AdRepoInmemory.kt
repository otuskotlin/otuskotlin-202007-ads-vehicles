package ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.repositories

import org.cache2k.Cache
import ru.otus.otuskotlin.ads_vehicles.backend.contexts.AdContext
import ru.otus.otuskotlin.ads_vehicles.backend.convertMileage
import ru.otus.otuskotlin.ads_vehicles.backend.exceptions.AdNotFound
import ru.otus.otuskotlin.ads_vehicles.backend.models.ad.Ad
import ru.otus.otuskotlin.ads_vehicles.backend.models.ad.Mileage
import ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.buildCache
import ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.dto.AdInmemoryDto
import ru.otus.otuskotlin.ads_vehicles.storage.common.repositories.IAdRepository
import java.util.*
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class AdRepoInmemory(
        ttl: Duration,
        private val makeRepository: MakeRepoInmemory,
        private val modelRepository: ModelRepoInmemory,
        private val generationRepository: GenerationRepoInmemory,
        private val equipmentRepository: EquipmentRepoInmemory
) : IAdRepository, AbstractRepoInmemory<Ad, AdInmemoryDto, Unit>() {
    override val cache: Cache<String, AdInmemoryDto> = buildCache(ttl)

    override suspend fun get(id: String): Ad {
        val dto: AdInmemoryDto = this.cache.get(id) ?: throw AdNotFound(id)
        return dto.model(
                make = this.makeRepository.get(dto.makeId!!),
                model = this.modelRepository.get(dto.modelId!!),
                generation = this.generationRepository.get(dto.generationId!!),
                equipment = this.equipmentRepository.get(dto.equipmentId!!)
        )
    }

    @OptIn(ExperimentalUnsignedTypes::class)
    override suspend fun index(filter: AdContext.Filter): Collection<Ad> = this.cache.asMap()
            .filter { filter.makeId?.let { makeId -> it.value.makeId == makeId } ?: true }
            .filter { filter.modelId?.let { modelId -> it.value.modelId == modelId } ?: true }
            .filter { filter.generationId?.let { generationId -> it.value.generationId == generationId } ?: true }
            .filter { filter.equipmentId?.let { equipmentId -> it.value.equipmentId == equipmentId } ?: true }
            .filter { filter.yearFrom?.let { yearFrom ->
                it.value.year?.let { year -> year >= yearFrom.value.toUShort() } ?: true
            } ?: true }
            .filter { filter.yearTo?.let { yearTo ->
                it.value.year?.let { year -> year <= yearTo.value.toUShort() } ?: true
            } ?: true }
            .filter {
                filter.mileageFrom?.let { true } ?: true    // todo: implement
            }
            .filter {
                filter.mileageTo?.let { true } ?: true      // todo: implement
            }
            .filter {
                filter.priceFrom?.let { true } ?: true      // todo: implement
            }
            .filter {
                filter.priceTo?.let { true } ?: true        // todo: implement
            }
            .filter {
                filter.maxOwners?.let { maxOwners ->
                    it.value.owners?.let { owners -> owners.toInt() <= maxOwners } ?: true
                } ?: true
            }
            .filter {
                filter.noNeedForRepair?.let { noNeedForRepair ->
                    it.value.needsRepair !== null && it.value.needsRepair!! != noNeedForRepair
                } ?: true
            }
            .filter {
                filter.withPictures?.let { withPictures ->
                    (it.value.pictureIds != null && it.value.pictureIds!!.isNotEmpty()) == withPictures
                } ?: true
            }
            .map {
                it.value.model(
                        make = this.makeRepository.get(it.value.makeId!!),
                        model = this.modelRepository.get(it.value.modelId!!),
                        generation = this.generationRepository.get(it.value.generationId!!),
                        equipment = this.equipmentRepository.get(it.value.equipmentId!!)
                )
            }

    override suspend fun create(ad: Ad): Ad {
        val id: String = ad.id ?: UUID.randomUUID().toString()
        this.cache.put(id, AdInmemoryDto.of(ad))
        return this.cache.get(id).let {
            it.model(
                    make = this.makeRepository.get(it.makeId!!),
                    model = this.modelRepository.get(it.modelId!!),
                    generation = this.generationRepository.get(it.generationId!!),
                    equipment = this.equipmentRepository.get(it.equipmentId!!)
            )
        }
    }

    override suspend fun update(ad: Ad): Ad {
        this.cache.get(ad.id) ?: throw AdNotFound(ad.id!!)
        this.cache.put(ad.id, AdInmemoryDto.of(ad))
        return this.cache.get(ad.id).let {
            it.model(
                    make = this.makeRepository.get(it.makeId!!),
                    model = this.modelRepository.get(it.modelId!!),
                    generation = this.generationRepository.get(it.generationId!!),
                    equipment = this.equipmentRepository.get(it.equipmentId!!)
            )
        }
    }
}
package ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.repositories

import org.cache2k.Cache
import ru.otus.otuskotlin.ads_vehicles.backend.contexts.MakeContext
import ru.otus.otuskotlin.ads_vehicles.backend.exceptions.MakeNotFound
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Make
import ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.buildCache
import ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.dto.MakeInmemoryDto
import ru.otus.otuskotlin.ads_vehicles.storage.common.repositories.IMakeRepository
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class MakeRepoInmemory(
        ttl: Duration,
        initObjects: Collection<Make> = emptyList()
) : IMakeRepository, AbstractRepoInmemory<Make, MakeInmemoryDto, Unit>() {
    override val cache: Cache<String, MakeInmemoryDto> = buildCache(ttl, initObjects, MakeInmemoryDto::of)

    override suspend fun get(id: String): Make =
            cache.get(id)?.model() ?: throw MakeNotFound(id)

    override suspend fun index(filter: MakeContext.Filter): Collection<Make> = this.cache.asMap()
            .filter {
                filter.searchString?.let { searchString -> it.value.name?.contains(searchString, true) ?: true } ?: true
            }
            .filter {
                filter.isoCountry?.let { isoCountry -> it.value.isoCountryCode?.equals(isoCountry) ?: true } ?: true
            }
            .map { it.value.model() }

    override suspend fun create(make: Make): Make {
        this.cache.put(make.id, MakeInmemoryDto.of(make))
        return this.cache.get(make.id).model()
    }
}
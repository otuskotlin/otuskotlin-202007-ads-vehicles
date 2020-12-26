package ru.otus.otuskotlin.ads_vehicles.storage.common.repositories

import ru.otus.otuskotlin.ads_vehicles.backend.contexts.GenerationContext
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Generation

interface IGenerationRepository {
    suspend fun get(id: String): Generation
    suspend fun index(filter: GenerationContext.Filter): Collection<Generation>
    suspend fun create(generation: Generation): Generation

    companion object {
        val NONE = object: IGenerationRepository {
            override suspend fun get(id: String): Generation {
                TODO("Not yet implemented")
            }

            override suspend fun index(filter: GenerationContext.Filter): Collection<Generation> {
                TODO("Not yet implemented")
            }

            override suspend fun create(generation: Generation): Generation {
                TODO("Not yet implemented")
            }
        }
    }
}
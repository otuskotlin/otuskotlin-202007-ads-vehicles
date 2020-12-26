package ru.otus.otuskotlin.ads_vehicles.storage.common.repositories

import ru.otus.otuskotlin.ads_vehicles.backend.contexts.MakeContext
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Make

interface IMakeRepository {
    suspend fun get(id: String): Make
    suspend fun index(filter: MakeContext.Filter): Collection<Make>
    suspend fun create(make: Make): Make

    companion object {
        val NONE = object: IMakeRepository {
            override suspend fun get(id: String): Make {
                TODO("Not yet implemented")
            }

            override suspend fun index(filter: MakeContext.Filter): Collection<Make> {
                TODO("Not yet implemented")
            }

            override suspend fun create(make: Make): Make {
                TODO("Not yet implemented")
            }
        }
    }
}
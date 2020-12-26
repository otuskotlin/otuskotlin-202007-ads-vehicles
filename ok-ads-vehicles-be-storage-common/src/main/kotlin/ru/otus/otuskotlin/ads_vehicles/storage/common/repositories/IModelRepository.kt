package ru.otus.otuskotlin.ads_vehicles.storage.common.repositories

import ru.otus.otuskotlin.ads_vehicles.backend.contexts.ModelContext
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Model

interface IModelRepository {
    suspend fun get(id: String): Model
    suspend fun index(filter: ModelContext.Filter): Collection<Model>
    suspend fun create(model: Model): Model

    companion object {
        val NONE = object: IModelRepository {
            override suspend fun get(id: String): Model {
                TODO("Not yet implemented")
            }

            override suspend fun index(filter: ModelContext.Filter): Collection<Model> {
                TODO("Not yet implemented")
            }

            override suspend fun create(model: Model): Model {
                TODO("Not yet implemented")
            }
        }
    }
}
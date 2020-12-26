package ru.otus.otuskotlin.ads_vehicles.storage.common.repositories

import ru.otus.otuskotlin.ads_vehicles.backend.contexts.EquipmentContext
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Equipment

interface IEquipmentRepository {
    suspend fun get(id: String): Equipment
    suspend fun index(filter: EquipmentContext.Filter): Collection<Equipment>
    suspend fun create(equipment: Equipment): Equipment

    companion object {
        val NONE = object: IEquipmentRepository {
            override suspend fun get(id: String): Equipment {
                TODO("Not yet implemented")
            }

            override suspend fun index(filter: EquipmentContext.Filter): Collection<Equipment> {
                TODO("Not yet implemented")
            }

            override suspend fun create(equipment: Equipment): Equipment {
                TODO("Not yet implemented")
            }
        }
    }
}
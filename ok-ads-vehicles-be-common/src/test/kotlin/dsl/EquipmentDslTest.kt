package ru.otus.otuskotlin.ads_vehicles.backend.dsl.dsl

import ru.otus.otuskotlin.ads_vehicles.backend.dsl.equipment.equipment
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.enums.DriveType
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.enums.EngineType
import kotlin.test.Test
import kotlin.test.assertEquals

class EquipmentDslTest {
    @Test
    public fun testDsl(): Unit {
        val equipment = equipment {
            engine { EngineType.PETROL }
            drive { DriveType.FULL_TIME_AWD }
        }

        assertEquals(EngineType.PETROL, equipment.engineType)
    }
}
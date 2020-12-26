package ru.otus.otuskotlin.ads_vehicles.backend.dsl.dsl

import ru.otus.otuskotlin.ads_vehicles.backend.dsl.model.model
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Make
import kotlin.test.Test
import kotlin.test.assertEquals

class ModelDslTest {
    @Test
    public fun testModelDslCustomId(): Unit {
        val model = model {
            id { "testid" }
            make { Make.NONE }
            name { "Hilux" }
        }

        assertEquals("testid", model.id)
        assertEquals(Make.NONE, model.make)
        assertEquals("Hilux", model.name)
    }

    @Test
    public fun testModelDslDigestId(): Unit {
        val model = model {
            make { Make.NONE }
            name { "Touareg" }
        }

        assertEquals("ea1f8a4a167abdd153fdc9db4252b89ea42a6e00", model.id)
        assertEquals(Make.NONE, model.make)
        assertEquals("Touareg", model.name)
    }
}
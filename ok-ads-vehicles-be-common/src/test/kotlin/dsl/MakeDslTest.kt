package ru.otus.otuskotlin.ads_vehicles.backend.dsl.dsl

import ru.otus.otuskotlin.ads_vehicles.backend.dsl.make.make
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Make
import kotlin.test.Test
import kotlin.test.assertEquals

class MakeDslTest {
    @Test
    public fun testMakeDslCustomId(): Unit {
        val make: Make = make {
            id { "testid" }
            name { "Skoda" }
            isoCountryCode { "CZ" }
        }

        assertEquals("testid", make.id)
        assertEquals("Skoda", make.name)
        assertEquals("CZ", make.isoCountryCode)
    }

    @Test
    public fun testMakeDslDigestId(): Unit {
        val make = make {
            name { "Volvo" }
            isoCountryCode { "SE" }
        }

        assertEquals("01f52a56298c5a7bc75bab39bb50b9307b419724", make.id)
        assertEquals("Volvo", make.name)
        assertEquals("SE", make.isoCountryCode)
    }
}
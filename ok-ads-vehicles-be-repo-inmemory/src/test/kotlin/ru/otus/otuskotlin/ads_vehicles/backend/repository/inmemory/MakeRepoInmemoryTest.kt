package ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory

import kotlinx.coroutines.runBlocking
import ru.otus.otuskotlin.ads_vehicles.backend.contexts.MakeContext
import ru.otus.otuskotlin.ads_vehicles.backend.dsl.make.make
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Make
import ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.repositories.MakeRepoInmemory
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime
import kotlin.time.toDuration

class MakeRepoInmemoryTest {
    @OptIn(ExperimentalTime::class)
    @Test
    fun testCreateAndGet(): Unit {
        val repo = MakeRepoInmemory(1.toDuration(DurationUnit.HOURS))

        val testMake = Make(
                UUID.randomUUID().toString(),
                "Audi",
                "DE"
        )

        runBlocking {
            val createdMake: Make = repo.create(testMake)
            assertEquals(testMake.id, createdMake.id)
            assertEquals(testMake.name, createdMake.name)
            assertEquals(testMake.isoCountryCode, createdMake.isoCountryCode)
        }

        runBlocking {
            val foundMake: Make = repo.get(testMake.id!!)
            assertEquals(testMake.id, foundMake.id)
            assertEquals(testMake.name, foundMake.name)
            assertEquals(testMake.isoCountryCode, foundMake.isoCountryCode)
        }
    }

    @OptIn(ExperimentalTime::class)
    @Test
    fun testFilter(): Unit {
        val repo = MakeRepoInmemory(
                ttl = 1.toDuration(DurationUnit.HOURS),
                initObjects = listOf(
                        make {
                            name { "Audi" }
                            isoCountryCode { "DE" }
                        },
                        Make(
                                UUID.randomUUID().toString(),
                                "BMW",
                                "DE"
                        ),
                        Make(
                                UUID.randomUUID().toString(),
                                "Toyota",
                                "JP"
                        ),
                        Make(
                                UUID.randomUUID().toString(),
                                "Nissan",
                                "JP"
                        ),
                        Make(
                                UUID.randomUUID().toString(),
                                "Jaguar",
                                "GB"
                        ),
                        Make(
                                UUID.randomUUID().toString(),
                                "Renault",
                                "FR"
                        ),
                        Make(
                                UUID.randomUUID().toString(),
                                "Seat",
                                "ES"
                        ),
                        Make(
                                UUID.randomUUID().toString(),
                                "Lamborghini",
                                "IT"
                        )
                )
            )

        runBlocking {
            repo.index(MakeContext.Filter("DE")).forEach {
                assertEquals("DE", it.isoCountryCode)
            }
            repo.index(MakeContext.Filter("FR")).forEach {
                assertEquals("FR", it.isoCountryCode)
            }
            repo.index(MakeContext.Filter("JP")).forEach {
                assertEquals("JP", it.isoCountryCode)
            }
            repo.index(MakeContext.Filter(searchString = "au")).forEach {
                assertTrue(listOf<String>("Audi", "Renault").contains(it.name))
            }
        }
    }
}
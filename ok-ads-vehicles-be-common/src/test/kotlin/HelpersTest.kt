package ru.otus.otuskotlin.ads_vehicles.backend.dsl

import ru.otus.otuskotlin.ads_vehicles.backend.sha1
import kotlin.test.Test
import kotlin.test.assertEquals

class HelpersTest {
    @Test
    fun testSha1(): Unit {
        val digest = sha1("hashme")
        assertEquals("fb78992e561929a6967d5328f49413fa99048d06", digest)
    }
}
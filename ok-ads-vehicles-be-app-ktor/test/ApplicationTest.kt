package ru.otus.otuskotlin.ads_vehicles

import com.typesafe.config.ConfigFactory
import io.ktor.application.*
import io.ktor.config.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.content.*
import io.ktor.http.content.*
import io.ktor.features.*
import kotlin.test.*
import io.ktor.server.testing.*
import io.ktor.util.*
import kotlinx.serialization.json.Json
import org.junit.BeforeClass
import ru.otus.otuskotlin.ads_vehicles.backend.models.ad.Mileage
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpAdCreateQuery
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpByIdQuery
import ru.otus.otuskotlin.ads_vehicles.transport.models.ad.KmpAd

class ApplicationTest {
    @Test
    fun getAd() {
        with(engine) {
            var id: String? = null

            handleRequest(HttpMethod.Post, "/api/ad") {
                val body = KmpAdCreateQuery(
                        year = 2007,
                        mileage = ru.otus.otuskotlin.ads_vehicles.transport.models.ad.KmpMileage(
                                value = 10000,
                                unit = "km"
                        ),
                        owners = 3,
                        price = ru.otus.otuskotlin.ads_vehicles.transport.models.ad.KmpMoneyAmount(
                                amount = 100000,
                                currency = "RUB"
                        ),
                        makeId = "0fee08a6f90299dbd4f51d4a7bf03cbb683884a9",
                        modelId = "3e81afef6be6469a95f38c698fb0209c2e8fb821",
                        generationId = "0720a2fe6024a5b40c19b390f5350d947eb1b581",
                        equipmentId = "11dade1da4b116f7c78cc3429bc96e0252840327"
                )

                val bodyString = Json.encodeToString(KmpAdCreateQuery.serializer(), body)
                setBody(bodyString)
                addHeader("Content-Type", "application/json")
            }.apply {
                val json = response.content ?: fail("Empty response!")
                val response = Json.decodeFromString(KmpAd.serializer(), json)
                id = response.id ?: fail("Response ID is missing")
            }

            handleRequest(HttpMethod.Post, "/api/get") {
                val body = KmpByIdQuery(
                        id = id
                )
                val bodyString = Json.encodeToString(KmpByIdQuery.serializer(), body)
                setBody(bodyString)
                addHeader("Content-Type", "application/json")
            }.apply {
                assertEquals(HttpStatusCode.OK, response.status())

                assertEquals(ContentType.Application.Json.withCharset(Charsets.UTF_8), response.contentType())
                val json = response.content ?: fail("Null response json")
                val response = Json.decodeFromString(KmpAd.serializer(), json)

                this@ApplicationTest.validateAdContents(
                        id = id!!,
                        mileageValue = 10000,
                        mileageUnit = "km",
                        owners = 3,
                        priceAmount = 100000,
                        priceCurrency = "RUB",
                        makeId = "0fee08a6f90299dbd4f51d4a7bf03cbb683884a9",
                        modelId = "3e81afef6be6469a95f38c698fb0209c2e8fb821",
                        generationId = "0720a2fe6024a5b40c19b390f5350d947eb1b581",
                        equipmentId = "11dade1da4b116f7c78cc3429bc96e0252840327",
                        responseAd = response
                )
            }
        }
    }

    private fun validateAdContents(
            id: String,
            mileageValue: Int?,
            mileageUnit: String?,
            owners: Int?,
            priceAmount: Int?,
            priceCurrency: String?,
            makeId: String?,
            modelId: String?,
            generationId: String?,
            equipmentId: String?,
            responseAd: KmpAd
    ): Unit {
        assertEquals(id, responseAd.id)
        if (mileageValue != null || mileageUnit != null) {
            assertNotNull(responseAd.mileage)

            if (mileageValue != null) {
                assertNotNull(responseAd.mileage!!.value)
                assertEquals(mileageValue, responseAd.mileage!!.value)
            }

            if (mileageUnit != null) {
                assertNotNull(responseAd.mileage!!.unit)
                assertEquals(mileageUnit, responseAd.mileage!!.unit)
            }
        }

        if (owners != null) {
            assertEquals(owners, responseAd.owners)
        }

        if (priceAmount != null || priceCurrency != null) {
            assertNotNull(responseAd.price)

            if (priceAmount != null) {
                assertEquals(priceAmount, responseAd.price!!.amount)
            }

            if (priceCurrency != null) {
                assertEquals(priceCurrency, responseAd.price!!.currency)
            }
        }

        if (makeId != null) {
            assertEquals(makeId, responseAd.makeId)
        }

        if (modelId != null) {
            assertEquals(modelId, responseAd.modelId)
        }

        if (generationId != null) {
            assertEquals(generationId, responseAd.generationId)
        }

        if (equipmentId != null) {
            assertEquals(equipmentId, responseAd.equipmentId)
        }
    }

    companion object {
        @OptIn(KtorExperimentalAPI::class)
        private val engine = TestApplicationEngine(createTestEnvironment {
            config = HoconApplicationConfig(ConfigFactory.load("application.conf"))
        })

        @BeforeClass
        @JvmStatic
        fun setup() {
            engine.start(wait = false)
        }
    }
}

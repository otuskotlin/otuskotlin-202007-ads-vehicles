package ru.otus.otuskotlin.ads_vehicles

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import kotlinx.serialization.json.Json
import ru.otus.otuskotlin.ads_vehicles.backend.datasets.FullStock
import ru.otus.otuskotlin.ads_vehicles.backend.repositories.IMakeRepository
import ru.otus.otuskotlin.ads_vehicles.backend.repositories.IRepositoryFactory
import ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.repositories.MakeRepoInmemory
import ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.repositories.RepositoryFactory
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpEquipmentIndexQuery
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpGenerationIndexQuery
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpMakeIndexQuery
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpModelIndexQuery
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime
import kotlin.time.toDuration

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    val repoFactory: IRepositoryFactory = RepositoryFactory(FullStock())
    val service: KmpStockService = KmpStockService(
            makeRepository = repoFactory.getMakeRepository(),
            modelRepository = repoFactory.getModelRepository(),
            generationRepository = repoFactory.getGenerationRepository(),
            equipmentRepository = repoFactory.getEquipmentRepository()
    )

    install(CORS) {
        method(HttpMethod.Options)
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        method(HttpMethod.Patch)
        header(HttpHeaders.Authorization)
        header("MyCustomHeader")
        allowCredentials = true
        anyHost() // @TODO: Don't do this in production if possible. Try to limit it.
    }

    install(ContentNegotiation) {
        json(
                contentType = ContentType.Application.Json,
                json = Json {
                    prettyPrint = true
                }
        )
    }

    routing {
        route("/api") {
            get("/make/index") {
                call.respond(service.indexMake(call.receive<KmpMakeIndexQuery>()))
            }

            get("/model/index") {
                call.respond(service.indexModel(call.receive<KmpModelIndexQuery>()))
            }

            get("/generation/index") {
                call.respond(service.indexGeneration(call.receive<KmpGenerationIndexQuery>()))
            }

            get("/equipment/index") {
                call.respond(service.indexEquipment(call.receive<KmpEquipmentIndexQuery>()))
            }

            post("/ad") {

            }

            patch("/ad") {

            }

            get("/ad/index") {

            }

            get("/ad") {

            }
        }
    }
}


package ru.otus.otuskotlin.ads_vehicles

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import kotlinx.serialization.json.Json
import ru.otus.otuskotlin.ads_vehicles.backend.logics.AdCrud
import ru.otus.otuskotlin.ads_vehicles.backend.logics.MakeCrud
import ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.repositories.RepositoryFactory
import ru.otus.otuskotlin.ads_vehicles.storage.common.repositories.IRepositoryFactory
import ru.otus.otuskotlin.ads_vehicles.storage.fixtures.FullStock
import ru.otus.otuskotlin.ads_vehicles.transport.models.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    val repoFactory: IRepositoryFactory = RepositoryFactory(FullStock())
    val stockService: KmpStockService = KmpStockService(
            makeCrud = MakeCrud(repoFactory.getMakeRepository()),
            modelRepository = repoFactory.getModelRepository(),
            generationRepository = repoFactory.getGenerationRepository(),
            equipmentRepository = repoFactory.getEquipmentRepository()
    )
    val adService: KmpAdService = KmpAdService(AdCrud(
            adRepository = repoFactory.getAdRepository(),
            equipmentRepository = repoFactory.getEquipmentRepository()
    ))

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
                call.respond(stockService.indexMake(call.receive<KmpMakeIndexQuery>()))
            }

            get("/model/index") {
                call.respond(stockService.indexModel(call.receive<KmpModelIndexQuery>()))
            }

            get("/generation/index") {
                call.respond(stockService.indexGeneration(call.receive<KmpGenerationIndexQuery>()))
            }

            get("/equipment/index") {
                call.respond(stockService.indexEquipment(call.receive<KmpEquipmentIndexQuery>()))
            }

            post("/ad") {
                call.respond(adService.create(call.receive<KmpAdCreateQuery>()))
            }

            patch("/ad") {
                call.respond(adService.update(call.receive<KmpAdUpdateQuery>()))
            }

            get("/ad/index") {
                call.respond(adService.index(call.receive<KmpAdIndexQuery>()))
            }

            get("/ad") {
                call.respond(adService.get(call.receive<KmpByIdQuery>()))
            }
        }
    }
}


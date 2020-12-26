package ru.otus.otuskotlin.ads_vehicles

import ru.otus.otuskotlin.ads_vehicles.backend.GenericError
import ru.otus.otuskotlin.ads_vehicles.backend.contexts.*
import ru.otus.otuskotlin.ads_vehicles.backend.logics.MakeCrud
import ru.otus.otuskotlin.ads_vehicles.storage.common.repositories.*
import ru.otus.otuskotlin.ads_vehicles.transport.models.*
import ru.otus.otuskotlin.ads_vehicles.transport.multiplatform.backend.mappers.responseIndex
import ru.otus.otuskotlin.ads_vehicles.transport.multiplatform.backend.mappers.setQuery

class KmpStockService(
        private val makeCrud: MakeCrud,
        private val modelRepository: IModelRepository,
        private val generationRepository: IGenerationRepository,
        private val equipmentRepository: IEquipmentRepository
) {
    suspend fun indexMake(query: KmpMakeIndexQuery): KmpMakeIndexResponse = MakeContext().run {
        try {
            this@KmpStockService.makeCrud.index(this.setQuery(query))
        } catch (e: Throwable) {
            this.status = ContextStatus.FAILURE
            this.errors.add(GenericError(message = e.message, originalException = e))
        }

        this.responseIndex()
    }

    suspend fun indexModel(query: KmpModelIndexQuery): KmpModelIndexResponse = ModelContext().run {
        this.setQuery(query)

        this.responseModelIndex = this@KmpStockService.modelRepository.index(this.filter).toMutableList()

        this.responseIndex()
    }

    suspend fun indexGeneration(query: KmpGenerationIndexQuery): KmpGenerationIndexResponse = GenerationContext().run {
        this.setQuery(query)

        this.responseIndex = this@KmpStockService.generationRepository.index(this.filter).toMutableList()

        this.responseIndex()
    }

    suspend fun indexEquipment(query: KmpEquipmentIndexQuery): KmpEquipmentIndexResponse = EquipmentContext().run {
        this.setQuery(query)

        this.responseIndex = this@KmpStockService.equipmentRepository.index(this.filter).toMutableList()

        this.responseIndex()
    }
}
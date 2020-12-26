package ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.repositories

import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Equipment
import ru.otus.otuskotlin.ads_vehicles.storage.common.IVehicleStockFixtureDataSet
import ru.otus.otuskotlin.ads_vehicles.storage.common.exceptions.RepositoryIsNotInitialized
import ru.otus.otuskotlin.ads_vehicles.storage.common.repositories.*
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime
import kotlin.time.toDuration

class RepositoryFactory : IRepositoryFactory {
    private var makeRepository: MakeRepoInmemory? = null
    private var modelRepository: ModelRepoInmemory? = null
    private var generationRepository: GenerationRepoInmemory? = null
    private var equipmentRepository: EquipmentRepoInmemory? = null
    private var adRepository: AdRepoInmemory? = null

    constructor(vehicleStockDataSet: IVehicleStockFixtureDataSet, ttlHours: Int? = null) {
        @OptIn(ExperimentalTime::class)
        val ttl: Duration = (ttlHours ?: 24).toDuration(DurationUnit.HOURS)
        val equipments: Collection<Equipment> = vehicleStockDataSet.getTree()

        this.makeRepository = MakeRepoInmemory(ttl, equipments.map { it.generation }.map { it.model }.map { it.make })
        this.modelRepository = ModelRepoInmemory(
                ttl,
                equipments.map { it.generation }.map { it.model },
                this.makeRepository!!
        )
        this.generationRepository = GenerationRepoInmemory(
                ttl,
                equipments.map { it.generation },
                this.modelRepository!!
        )
        this.equipmentRepository = EquipmentRepoInmemory(ttl, equipments, this.generationRepository!!)
        this.adRepository = AdRepoInmemory(
                ttl,
                this.makeRepository!!,
                this.modelRepository!!,
                this.generationRepository!!,
                this.equipmentRepository!!
        )
    }

    override fun getMakeRepository(): IMakeRepository {
        return this.makeRepository ?: throw RepositoryIsNotInitialized(MakeRepoInmemory::class.toString())
    }

    override fun getModelRepository(): IModelRepository {
        return this.modelRepository ?: throw RepositoryIsNotInitialized(ModelRepoInmemory::class.toString())
    }

    override fun getGenerationRepository(): IGenerationRepository {
        return this.generationRepository ?: throw RepositoryIsNotInitialized(GenerationRepoInmemory::class.toString())
    }

    override fun getEquipmentRepository(): IEquipmentRepository {
        return this.equipmentRepository ?: throw RepositoryIsNotInitialized(EquipmentRepoInmemory::class.toString())
    }

    override fun getAdRepository(): IAdRepository {
        return this.adRepository ?: throw RepositoryIsNotInitialized(AdRepoInmemory::class.toString())
    }
}
package ru.otus.otuskotlin.ads_vehicles.backend.repositories

interface IRepositoryFactory {
    fun getMakeRepository(): IMakeRepository
    fun getModelRepository(): IModelRepository
    fun getGenerationRepository(): IGenerationRepository
    fun getEquipmentRepository(): IEquipmentRepository
}
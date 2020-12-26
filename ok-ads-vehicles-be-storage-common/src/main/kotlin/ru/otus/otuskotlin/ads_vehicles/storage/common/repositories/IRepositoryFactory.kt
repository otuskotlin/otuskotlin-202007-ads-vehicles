package ru.otus.otuskotlin.ads_vehicles.storage.common.repositories

interface IRepositoryFactory {
    fun getMakeRepository(): IMakeRepository
    fun getModelRepository(): IModelRepository
    fun getGenerationRepository(): IGenerationRepository
    fun getEquipmentRepository(): IEquipmentRepository
    fun getAdRepository(): IAdRepository
}
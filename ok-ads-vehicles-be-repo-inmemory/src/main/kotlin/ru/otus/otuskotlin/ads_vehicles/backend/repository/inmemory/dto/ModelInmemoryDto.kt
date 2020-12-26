package ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.dto

import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Make
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Model

data class ModelInmemoryDto(
        val id: String? = null,
        val makeId: String? = null,
        val name: String? = null
) {
    companion object {
        fun of(model: Model) = of(model, model.id)
        fun of(model: Model, id: String?) = ModelInmemoryDto(
                id = model.id,
                makeId = model.make.id,
                name = model.name
        )
    }

    fun model(make: Make): Model = Model(
            id = this.id,
            make = make,
            name = this.name
    )
}

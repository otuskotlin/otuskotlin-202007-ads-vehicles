package ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.dto

import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Generation
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Model
import java.time.Year

data class GenerationInmemoryDto(
        val id: String? = null,
        val modelId: String? = null,
        val name: String? = null,
        val yearFrom: Int? = null,
        val yearTo: Int? = null
) {
    companion object {
        fun of(generation: Generation) = of(generation, generation.id)
        fun of(generation: Generation, id: String?) = GenerationInmemoryDto(
                id = id,
                modelId = generation.model.id,
                name = generation.name,
                yearFrom = generation.yearFrom?.value,
                yearTo = generation.yearTo?.value
        )
    }

    fun model(model: Model): Generation = Generation(
            id = this.id,
            model = model,
            name = this.name,
            yearFrom = Year.of(this.yearFrom ?: Year.MIN_VALUE),
            yearTo = Year.of(this.yearTo ?: Year.MAX_VALUE)
    )
}

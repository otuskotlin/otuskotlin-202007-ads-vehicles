package ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.dto

import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Make

data class MakeInmemoryDto (
    var id: String? = null,
    var name: String? = null,
    var isoCountryCode: String? = null
) {
    companion object {
        fun of(make: Make) = of(make, make.id)

        fun of(make: Make, id: String?): MakeInmemoryDto = MakeInmemoryDto(
                id = id.takeIf { it != null },
                name = make.name,
                isoCountryCode = make.isoCountryCode
        )
    }

    fun model(): Make = Make(
            id = this.id,
            name = this.name,
            isoCountryCode = this.isoCountryCode
    )
}
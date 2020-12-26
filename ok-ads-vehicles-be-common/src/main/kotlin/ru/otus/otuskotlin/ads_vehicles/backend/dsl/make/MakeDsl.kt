package ru.otus.otuskotlin.ads_vehicles.backend.dsl.make

import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Make
import ru.otus.otuskotlin.ads_vehicles.backend.sha1

@MakeDslMarker
class MakeDsl {
    private var id: String = ""
    private var name: String = ""
    private var isoCountryCode: String = ""


    public fun build(): Make = Make(
            id = this.id.takeIf { it.isNotBlank() } ?: sha1(this.name),
            name = this.name,
            isoCountryCode = this.isoCountryCode
    )

    public fun id(lambda: () -> String): Unit {
        this.id = lambda()
    }

    public fun name(lambda: () -> String): Unit {
        this.name = lambda()
    }

    public fun isoCountryCode(lambda: () -> String): Unit {
        this.isoCountryCode = lambda()
    }
}

fun make(conf: MakeDsl.() -> Unit) = MakeDsl().apply(conf).build()
package ru.otus.otuskotlin.ads_vehicles.backend.dsl.generation

import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Generation
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Model
import ru.otus.otuskotlin.ads_vehicles.backend.sha1
import java.time.Year
import java.util.*

@GenerationDslMarker
class GenerationDsl {
    private var id: String = ""
    private var model: Model = Model.NONE
    private var name: String = ""
    private var yearFrom: Year = Year.of(Year.MIN_VALUE)
    private var yearTo: Year = Year.of(Year.MAX_VALUE)


    public fun build(): Generation = Generation(
            id = this.id.takeIf { it.isNotBlank() } ?: sha1(this.model.id.plus(this.name)),
            model = this.model,
            name = this.name,
            yearFrom = this.yearFrom,
            yearTo = this.yearTo
    )

    public fun id(lambda: () -> String): Unit {
        this.id = lambda()
    }

    public fun model(lambda: () -> Model): Unit {
        this.model = lambda()
    }

    public fun name(lambda: () -> String): Unit {
        this.name = lambda()
    }

    public fun yearFrom(lambda: () -> Int): Unit {
        this.yearFrom = Year.of(lambda())
    }

    public fun yearTo(lambda: () -> Int): Unit {
        this.yearTo = Year.of(lambda())
    }
}

fun generation(conf: GenerationDsl.() -> Unit) = GenerationDsl().apply(conf).build()
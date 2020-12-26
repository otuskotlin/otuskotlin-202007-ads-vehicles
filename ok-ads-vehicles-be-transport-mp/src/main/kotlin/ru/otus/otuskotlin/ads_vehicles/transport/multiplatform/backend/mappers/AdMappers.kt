package ru.otus.otuskotlin.ads_vehicles.transport.multiplatform.backend.mappers

import ru.otus.otuskotlin.ads_vehicles.backend.contexts.AbstractContext
import ru.otus.otuskotlin.ads_vehicles.backend.contexts.AdContext
import ru.otus.otuskotlin.ads_vehicles.backend.models.User
import ru.otus.otuskotlin.ads_vehicles.backend.models.ad.Ad
import ru.otus.otuskotlin.ads_vehicles.backend.models.ad.Mileage
import ru.otus.otuskotlin.ads_vehicles.backend.models.ad.MoneyAmount
import ru.otus.otuskotlin.ads_vehicles.backend.models.ad.Picture
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Equipment
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Generation
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Make
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Model
import ru.otus.otuskotlin.ads_vehicles.transport.models.*
import ru.otus.otuskotlin.ads_vehicles.transport.models.ad.KmpAd
import ru.otus.otuskotlin.ads_vehicles.transport.models.ad.KmpMileage
import ru.otus.otuskotlin.ads_vehicles.transport.models.ad.KmpMoneyAmount
import java.awt.Color
import java.time.LocalDate
import java.time.Year
import java.util.*

fun AdContext.setQuery(query: KmpAdCreateQuery) = this.apply {
    this.requestAd = query.model()
}

fun AdContext.setQuery(query: KmpAdUpdateQuery) = this.apply {
    this.requestAd = query.model()
}

fun AdContext.setQuery(query: KmpByIdQuery) = this.apply {
    this.requestAdId = query.id
}

fun AdContext.setQuery(query: KmpAdIndexQuery) = this.apply {
    if (query.limit != null || query.offset != null) {
        this.index = AbstractContext.Index(query.limit, query.offset)
    }

    this.sorting = query.sorting?.let {
        AbstractContext.Sorting(
                by = it.by,
                order = it.order?.toSortingOrder() ?: AbstractContext.Sorting.SortingOrder.DEFAULT
        )
    }

    this.filter = query.filter?.let {
        AdContext.Filter(
                makeId = it.makeId,
                modelId = it.modelId,
                generationId = it.generationId,
                equipmentId = it.equipmentId,
                yearFrom = it.yearFrom?.let { Year.of(it) },
                yearTo = it.yearTo?.let { Year.of(it) },
                mileageFrom = it.mileageFrom?.model(),
                mileageTo = it.mileageTo?.model(),
                priceFrom = it.priceFrom?.model(),
                priceTo = it.priceTo?.model(),
                maxOwners = it.maxOwners,
                noNeedForRepair = it.noNeedForRepair,
                withPictures = it.withPictures
        )
    } ?: AdContext.Filter.NONE
}

fun AdContext.responseItem(): KmpAd = this.responseAd.kmp()

fun AdContext.responseIndex(): KmpAdIndexResponse = KmpAdIndexResponse(
        data = this.responseIndex.map { it.kmp() },
        limit = this.index?.limit,
        offset = this.index?.offset
)

fun Ad.kmp() = KmpAd(
        id = this.id,
        year = this.year?.value,
        mileage = this.mileage.kmp(),
        owners = this.owners,
        price = this.price.kmp(),
        vin = this.vin,
        licensePlate = this.licensePlate,
        colour = this.colour?.rgb,
        makeId = this.make.id,
        modelId = this.model.id,
        generationId = this.generation.id,
        equipmentId = this.equipment.id,
        needsRepair = this.needsRepair,
        pictureIds = this.pictures?.map { it.id!! },
        description = this.description,
        userId = this.user.id,
        date = this.date?.toString(),
        isActive = this.isActive
)

fun KmpAdSaveQuery.model(): Ad = Ad(
        id = if (this is KmpAdUpdateQuery) this.id else null,
        year = this.year?.let { Year.of(it) },
        mileage = this.mileage?.model() ?: Mileage.NONE,
        owners = this.owners,
        price = this.price?.model() ?: MoneyAmount.NONE,
        vin = this.vin,
        licensePlate = this.licensePlate,
        colour = this.colour?.let { Color(it) },
        make = this.makeId?.let { Make(id = it) } ?: Make.NONE,
        model = this.modelId?.let { Model(id = it) } ?: Model.NONE,
        generation = this.generationId?.let { Generation(id = it) } ?: Generation.NONE,
        equipment = this.equipmentId?.let { Equipment(id = it) } ?: Equipment.NONE,
        needsRepair = this.needsRepair,
        pictures = this.pictures?.map { it.toPicture() } ?.toMutableList(),
        description = this.description,
        user = this.userId?.let { User(id = it) } ?: User.NONE,
        date = LocalDate.now(),
        isActive = true
)

fun Mileage.kmp(): KmpMileage = KmpMileage(
        value = this.value,
        unit = this.unit?.kmpToString()
)

fun Mileage.MileageUnit.kmpToString(): String = when (this) {
    Mileage.MileageUnit.KM -> "km"
    Mileage.MileageUnit.MI -> "mi"
}

fun MoneyAmount.kmp(): KmpMoneyAmount = KmpMoneyAmount(
        amount = this.amount,
        currency = this.currency?.currencyCode
)

fun KmpMoneyAmount.model(): MoneyAmount = MoneyAmount(
        amount = this.amount,
        currency = this.currency.let { Currency.getInstance(it) }
)

fun KmpMileage.model(): Mileage = Mileage(
        value = this.value,
        unit = this.unit?.toMileageUnit() ?: Mileage.MileageUnit.DEFAULT
)


// how dirty is that?

private fun String.toMileageUnit(): Mileage.MileageUnit = when (this) {
    "km" -> Mileage.MileageUnit.KM
    "mi" -> Mileage.MileageUnit.MI
    else -> Mileage.MileageUnit.DEFAULT
}

private fun String.toPicture(): Picture = Picture.NONE

private fun String.toSortingOrder(): AbstractContext.Sorting.SortingOrder = when (this) {
    "asc" -> AbstractContext.Sorting.SortingOrder.ASC
    "desc" -> AbstractContext.Sorting.SortingOrder.ASC
    else -> AbstractContext.Sorting.SortingOrder.DEFAULT
}
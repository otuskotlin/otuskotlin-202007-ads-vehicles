package ru.otus.otuskotlin.ads_vehicles.backend

import ru.otus.otuskotlin.ads_vehicles.backend.models.ad.Mileage
import java.security.MessageDigest
import kotlin.math.roundToInt

fun sha1(input: String): String {
    return MessageDigest.getInstance("SHA-1")
            .digest(input.toByteArray())
            .joinToString(separator = "") { "%02x".format(it) }
}

fun convertMileage(unitFrom: Mileage.MileageUnit, unitTo: Mileage.MileageUnit, value: Int): Int {
    if (unitFrom.equals(unitTo)) return value

    if (unitFrom.equals(Mileage.MileageUnit.KM) && unitTo.equals(Mileage.MileageUnit.MI)) {
        return (value * Constants.KM_MI_RATIO).roundToInt()
    }

    if (unitFrom.equals(Mileage.MileageUnit.MI) && unitTo.equals(Mileage.MileageUnit.KM)) {
        return (value / Constants.KM_MI_RATIO).roundToInt()
    }

    throw IllegalArgumentException("Something bad passed as argument")
}
package ru.otus.otuskotlin.ads_vehicles.backend.exceptions

import java.lang.RuntimeException

class AdNotFound(id: String) : RuntimeException("Ad ID=$id not found") {
}
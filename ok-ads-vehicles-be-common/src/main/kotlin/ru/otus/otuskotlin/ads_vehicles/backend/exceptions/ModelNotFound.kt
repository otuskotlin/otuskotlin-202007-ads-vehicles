package ru.otus.otuskotlin.ads_vehicles.backend.exceptions

class ModelNotFound(id: String) : RuntimeException("Model ID=$id not found") {
}
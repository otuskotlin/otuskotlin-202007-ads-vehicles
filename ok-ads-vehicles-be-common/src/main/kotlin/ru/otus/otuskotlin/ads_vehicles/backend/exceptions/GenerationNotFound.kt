package ru.otus.otuskotlin.ads_vehicles.backend.exceptions

class GenerationNotFound(id: String) : RuntimeException("Generation ID=$id not found") {
}
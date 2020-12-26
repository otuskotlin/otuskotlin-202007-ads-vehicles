package ru.otus.otuskotlin.ads_vehicles.storage.common.exceptions

class RepositoryIsNotInitialized(classname: String) : RuntimeException("Repository is not initialized: $classname") {
}
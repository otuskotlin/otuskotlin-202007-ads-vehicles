package ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.repositories

import org.cache2k.Cache
import ru.otus.otuskotlin.ads_vehicles.backend.models.IModel

abstract class AbstractRepoInmemory<Model : IModel, Dto, ParentRepo>(
        protected val parentRepo: ParentRepo? = null
) {
    protected abstract val cache: Cache<String, Dto>
}
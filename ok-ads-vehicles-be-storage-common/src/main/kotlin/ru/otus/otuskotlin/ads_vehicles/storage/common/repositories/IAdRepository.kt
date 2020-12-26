package ru.otus.otuskotlin.ads_vehicles.storage.common.repositories

import ru.otus.otuskotlin.ads_vehicles.backend.contexts.AdContext
import ru.otus.otuskotlin.ads_vehicles.backend.models.ad.Ad

interface IAdRepository {
    suspend fun get(id: String): Ad
    suspend fun index(filter: AdContext.Filter): Collection<Ad>
    suspend fun create(ad: Ad): Ad
    suspend fun update(ad: Ad): Ad

    companion object {
        val NONE = object: IAdRepository {
            override suspend fun get(id: String): Ad {
                TODO("Not yet implemented")
            }

            override suspend fun index(filter: AdContext.Filter): Collection<Ad> {
                TODO("Not yet implemented")
            }

            override suspend fun create(ad: Ad): Ad {
                TODO("Not yet implemented")
            }

            override suspend fun update(ad: Ad): Ad {
                TODO("Not yet implemented")
            }
        }
    }
}
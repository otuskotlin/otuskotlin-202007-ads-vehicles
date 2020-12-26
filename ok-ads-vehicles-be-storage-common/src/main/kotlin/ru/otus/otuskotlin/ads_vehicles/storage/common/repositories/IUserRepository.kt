package ru.otus.otuskotlin.ads_vehicles.storage.common.repositories

import ru.otus.otuskotlin.ads_vehicles.backend.models.User

interface IUserRepository {
    suspend fun get(id: String): User
    suspend fun create(user: User): User

    companion object {
        val NONE = object: IUserRepository {
            override suspend fun get(id: String): User {
                TODO("Not yet implemented")
            }

            override suspend fun create(user: User): User {
                TODO("Not yet implemented")
            }
        }
    }
}
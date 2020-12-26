package ru.otus.otuskotlin.ads_vehicles.backend.models

import java.time.LocalDate

/**
 * User
 */
data class User (
        /**
         * ID
         */
        override var id: String? = null,

        /**
         * Name
         */
        val name: String? = null,

        /**
         * Surname
         */
        val surname: String? = null,

        /**
         * Patronymic
         */
        val patronymic: String? = null,

        /**
         * Date of birth
         */
        val birthDate: LocalDate? = null,

        /**
         * Phone number
         */
        val phone: String? = null,

        /**
         * Date of registration
         */
        val registrationDate: LocalDate? = null,

        /**
         * Activity flag
         */
        val isActive: Boolean? = null
) : IModel {
    companion object {
        val NONE: User = User()
    }
}
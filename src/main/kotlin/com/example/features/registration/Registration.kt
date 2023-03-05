package com.example.features.registration

import kotlinx.serialization.Serializable

@Serializable
data class RegistrationReceive(
    val login: String,
    val email: String,
    val password: String
)

@Serializable
data class RegistrationResponse(
    val token: String
)
package com.example.cache

import com.example.features.registration.RegistrationReceive

data class TokenCache(
    val login: String,
    val token: String
)

object InMamoryCache {
    val userList: MutableList<RegistrationReceive> = mutableListOf()
    val token: MutableList<TokenCache> = mutableListOf()
}
package com.example.features.registration

import com.example.cache.InMamoryCache
import com.example.cache.TokenCache
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import java.util.*

class RegisterController {
    fun registerNewUser(registrationRecive: RegistrationReceive) {

        if (InMamoryCache.userList.map { it.login }.contains(receive.login)){
            call.respond(HttpStatusCode.Conflict, "User already exists")
        }

        val token = UUID.randomUUID().toString()
        InMamoryCache.userList.add(receive)
        InMamoryCache.token.add(TokenCache(login = receive.login, token = token))

        call.respond(RegistrationResponse(token = token))

    }
}
package com.example.features.registration

import com.example.cache.InMamoryCache
import com.example.cache.TokenCache
import com.example.features.login.LoginReceive
import com.example.features.login.LoginResponse
import com.example.utils.isValidEmail
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.*

fun Application.configureRegistrationRouting() {
    routing {
        post("/registration") {
            val receive = call.receive<RegistrationReceive>()
            if (!receive.email.isValidEmail()){
                call.respond(HttpStatusCode.BadRequest, "Email is not valid")
            }

        }
    }

}
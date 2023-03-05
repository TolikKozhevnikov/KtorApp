package com.example

import com.example.features.login.configureLoginRouting
import com.example.features.registration.configureRegistrationRouting
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import org.jetbrains.exposed.sql.Database

fun main() {
    Database.connect("jdbc:postgresql://localhost:5432/testbase", driver = "org.postgresql.Driver",
        user = "postgres")
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
            .start(wait = true)
}

fun Application.module() {

    configureSerialization()
    configureDatabases()
    configureSockets()
    configureRouting()
    configureLoginRouting()
    configureRegistrationRouting()
}

package fr.hamtec.routes

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        staticResources("/static","static")
        authenticate("auth-basic") {
            get("/") {
                call.respondText("Hello World!")
            }
        }
        get("/") {
            call.respondText("Welcome to the public endpoint!")
        }
    }
}

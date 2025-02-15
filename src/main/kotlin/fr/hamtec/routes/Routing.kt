package fr.hamtec.routes

import fr.hamtec.slog.logHeaders
import fr.hamtec.slog.logResponseHeaders
import fr.hamtec.slog.logger
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.http.content.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
//        staticResources("/static","static")
//        authenticate("auth-basic") {
//            get("/x") {
//                call.respondText("Hello World!")
//            }
//        }
//        get("/") {
//            logger.info("***** Public endpoint")
//            logHeaders(call)
//            logResponseHeaders(call)
//            call.respond("Welcome to the public endpoint!")
//            logHeaders(call)
//            logResponseHeaders(call)
//        }
        logger.info("***** ROUTING *****")
        get("/") {
            logger.info("***** GET *****")
            logHeaders(call)
            val acceptHeader = call.request.acceptItems()
            if (acceptHeader.any { it.value == ContentType.Application.Json.toString() }) {
                call.respond(HttpStatusCode.OK, mapOf("message" to "Welcome to the public endpoint!"))
            } else {
                call.respondText("Welcome to the public endpoint!", ContentType.Text.Plain)
            }
            logger.info("***** GET FIN *****")
            logResponseHeaders(call)
        }

    }
}

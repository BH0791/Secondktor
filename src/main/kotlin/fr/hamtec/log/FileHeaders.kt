package fr.hamtec.log

import io.ktor.server.application.*
import org.slf4j.LoggerFactory

val logger = LoggerFactory.getLogger("HTTP-HamTec")

fun logHeaders(context: ApplicationCall) {
    context.request.headers.forEach { header, value ->
        context.application.environment.log.info("***** Request Header: $header - $value")
    }
}

fun logResponseHeaders(context: ApplicationCall) {
    context.response.headers.allValues().forEach { header, value ->
        context.application.environment.log.info("***** Response Header: $header - $value")
    }
}
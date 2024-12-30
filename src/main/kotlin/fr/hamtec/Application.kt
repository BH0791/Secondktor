package fr.hamtec

import fr.hamtec.plugins.configureContentNegotiation
import fr.hamtec.routes.configureAuth
import fr.hamtec.routes.configureRouting
import fr.hamtec.routes.configureTemplating
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.cio.EngineMain.main(args)
}

fun Application.module() {
    configureContentNegotiation()
    configureTemplating()
    configureAuth()
    configureRouting()
}

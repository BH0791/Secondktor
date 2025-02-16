package fr.hamtec

import fr.hamtec.plugins.configureContentNegotiation
import fr.hamtec.plugins.configureRequestValidation
import fr.hamtec.plugins.configureStatusPages
import fr.hamtec.plugins.configureThemaleaf
import fr.hamtec.routes.configureAuth
import fr.hamtec.routes.configureRouting
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.cio.EngineMain.main(args)
}

fun Application.module() {
    configureContentNegotiation()
    //configureTemplating()
    configureRequestValidation()
    configureStatusPages()
    configureAuth()
    configureThemaleaf()

    configureRouting()
}

package fr.hamtec.routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.thymeleaf.Thymeleaf
import io.ktor.server.thymeleaf.ThymeleafContent
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver

fun Application.configureTemplating() {
    install(Thymeleaf) {
        setTemplateResolver(ClassLoaderTemplateResolver().apply {
            prefix = "templates/"
            suffix = ".html"
            characterEncoding = "utf-8"
        })
    }
    routing {
        get("/html-thymeleaf") {
            call.respond(ThymeleafContent("index", mapOf("user" to ThymeleafUser(1, "user1"))))
        }
        get("/about") {
            call.respond(ThymeleafContent("about/about", mapOf("title" to "À propos", "message" to "En savoir plus sur nous.")))
        }
        get("/contact") {
            call.respond(ThymeleafContent("contact/contact", mapOf("title" to "Contact", "message" to "Contactez-nous ici.")))
        }
    }
}
data class ThymeleafUser(val id: Int, val name: String)

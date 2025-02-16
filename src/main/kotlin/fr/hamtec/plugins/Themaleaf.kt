package fr.hamtec.plugins

import io.ktor.server.application.*
import io.ktor.server.thymeleaf.*
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver
import org.thymeleaf.templateresolver.FileTemplateResolver

//-https://ktor.io/docs/server-thymeleaf.html#template_loading
fun Application.configureThemaleaf() {
    install(Thymeleaf) {
        setTemplateResolver((if (developmentMode) {
            FileTemplateResolver().apply {
                cacheManager = null
                prefix = "src/main/resources/templates/thymeleaf/"
            }
        } else {
            ClassLoaderTemplateResolver().apply {
                prefix = "templates/thymeleaf/"
            }
        }).apply {
            suffix = ".html"
            characterEncoding = "utf-8"
        })
    }
}
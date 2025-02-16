package fr.hamtec.routes

import fr.hamtec.data.Team
import fr.hamtec.log.logHeaders
import fr.hamtec.log.logResponseHeaders
import fr.hamtec.log.logger
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.thymeleaf.*

fun Application.configureRouting() {
    routing {
        staticResources("/website", "frontend") {
            exclude { url ->
                url.path.startsWith("secret")
            }
        }
        logger.info("***** ROUTING *****")
        get("/team") {
            logger.info("***** GET *****")
            logHeaders(call)

            val team = call.receive<Team>()
            call.respondText("Hello, ${team.name}!")

            logger.info("***** GET FIN *****")
            logResponseHeaders(call)
        }
        get("/team/{team_id}") {
            val teamId: Int? = call.parameters["team_id"]?.toIntOrNull()
            if(teamId == null) {
                call.respond(HttpStatusCode.BadRequest, "team_id doit être un nombre entier")
            } else {
                val team = Team(teamId, "Laos")
                call.respond(HttpStatusCode.OK, team)
            }
        }
        get("/tete") {
            logger.info("***** GET *****")
            logHeaders(call)

            call.response.header("X-Man", 25)
            val head = call.request.headers["X-Man"]
            call.respondText("Accept-Language: $head")

            logger.info("***** GET FIN *****")
            logResponseHeaders(call)
        }
        get("/index") {
            val teamUser = Team(1, "Mexique")
            call.respond(ThymeleafContent("index", mapOf("user" to teamUser)))
        }

    }
}

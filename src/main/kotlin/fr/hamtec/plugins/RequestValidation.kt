package fr.hamtec.plugins

import fr.hamtec.data.Team
import io.ktor.server.application.*
import io.ktor.server.plugins.requestvalidation.*

fun Application.configureRequestValidation() {
    install(RequestValidation){
        validate<Team> {team ->
            if(team.id <= 0){
                ValidationResult.Invalid("L'id doit être un nombre entier positif")
            }else{
                ValidationResult.Valid
            }
        }
    }
}
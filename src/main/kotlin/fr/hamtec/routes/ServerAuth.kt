package fr.hamtec.routes

import io.ktor.server.application.*
import io.ktor.server.auth.*

fun Application.configureAuth(){
    install(Authentication){
        basic(name = "auth-basic") {
            realm = "ktor Server"
            validate { credentials ->
                if(credentials.name == "username" && credentials.password == "password" ){
                    UserIdPrincipal(credentials.name)
                }else{
                    null
                }
            }
        }
    }
}
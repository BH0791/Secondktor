package fr.hamtec.plugins

import io.ktor.serialization.kotlinx.cbor.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.serialization.kotlinx.protobuf.*
import io.ktor.serialization.kotlinx.xml.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.cbor.Cbor
import kotlinx.serialization.json.Json
import kotlinx.serialization.protobuf.ProtoBuf
import nl.adaptivity.xmlutil.XmlDeclMode
import nl.adaptivity.xmlutil.serialization.XML

@OptIn(ExperimentalSerializationApi::class)
fun Application.configureContentNegotiation() {
    install(ContentNegotiation){
        xml(format = XML {
            xmlDeclMode = XmlDeclMode.Charset
            indentString = " "
        })
        json(
            Json {
                prettyPrint = true
                isLenient = true
                encodeDefaults = true
                ignoreUnknownKeys = true
            }
        )
        cbor(Cbor {
            ignoreUnknownKeys = true
        })
        protobuf(ProtoBuf {
            encodeDefaults = true
        })
    }
}

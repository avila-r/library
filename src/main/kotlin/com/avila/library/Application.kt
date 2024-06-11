package com.avila.library

import com.avila.library.handler.configRouting

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(
        Netty,
        port = 5555,
        host = "0.0.0.0",
        module = Application::module
    ).start(wait = true)

    TODO("Embedded server properties not yet implemented at application.conf")

}

fun Application.module() {
    configRouting()
}
package com.avila.library.handler

import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

fun Application.configRouting() {

    install(StatusPages) {
        exception<IllegalStateException> {
            call, cause -> call.respondText { "App in illegal state as ${cause.message}" }
        }
    }

    /*
     * Enable API router
     */
    handler()

}
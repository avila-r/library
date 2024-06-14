package com.avila.library.handler

import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

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

    /*
     * Enable API docs
     */
    routing {
        swaggerUI(path = "docs", swaggerFile = "openapi/documentation.yaml")
    }

}
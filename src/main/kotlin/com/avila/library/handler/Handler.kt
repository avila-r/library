/**
 * Handlers for routing configurations related to book domain in the library application.
 */
package com.avila.library.handler

/*
 * Import book domain routes
 */
import com.avila.library.routes.*

import io.ktor.server.application.*
import io.ktor.server.routing.*

/**
 * Configures routing for book domain endpoints in the application.
 */
fun Application.handler() {
    routing {

        /*
         * Enable book domain routes
         */
        route("/api/v1/books") {
            allBooksRoutes()
        }

        // Additional routes can be configured here for other domain endpoints

    }
}
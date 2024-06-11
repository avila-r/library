package com.avila.library.router

/*
 * Import book domain routes
 */
import com.avila.library.routes.getBooksRoutes
import com.avila.library.routes.listBooksRoute
import com.avila.library.routes.postBooksRoute
import com.avila.library.routes.updateBooksRoute

import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.router() {
    routing {

        /*
         * Enable book domain routes
         */
        route("/api/v1/books") {
            listBooksRoute()
            getBooksRoutes()
            postBooksRoute()
            updateBooksRoute()
        }

    }
}
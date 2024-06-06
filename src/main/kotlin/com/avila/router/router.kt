package com.avila.router

/*
 * Import book domain routes
 */
import com.avila.domain.book.getBooksRoutes
import com.avila.domain.book.listBooksRoute
import com.avila.domain.book.postBooksRoute
import com.avila.domain.book.updateBooksRoute

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
package com.avila.api.routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.listBooksRoute() {
    get {
        // Todo: list books implementation

        call.respondText { "List books" }
    }
}

fun Route.getBooksRoutes() {
    get("/id/{id}") {

    }

    // ...
}

fun Route.postBooksRoute() {

}

fun Route.updateBooksRoute() {

}
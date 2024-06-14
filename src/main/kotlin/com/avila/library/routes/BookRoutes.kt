/**
 * Routes related to book management in the application.
 */
package com.avila.library.routes

import com.avila.library.schemas.BookRequest
import com.avila.library.schemas.HttpResultResponse
import com.avila.library.services.BookService
import com.avila.library.utils.getCustomJsonObjectMapper

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

/**
 * Service instance for book-related operations.
 */
private val service = BookService()

/**
 * Custom JSON object mapper configured for book-related responses.
 */
private val mapper = getCustomJsonObjectMapper()

/**
 * Routes
 */
fun Route.allBooksRoutes() {

    route("/api/v1/books") {
        listBooksRoute()
        getBooksRoutes()
        postBooksRoute()
        // TODO: updateBooksRoute()
    }

}

/** Route to list all books */
private fun Route.listBooksRoute() {
    get {
        call.respond(HttpStatusCode.OK, mapper.writeValueAsString(
            HttpResultResponse(service.getAll()))
        )
    }
}

/** Route to get a specific book by ID */
private fun Route.getBooksRoutes() {
    get("/id/{id}") {

        val id: Long? = call.parameters["id"]?.toLongOrNull()

        id?.let {
            call.respond(HttpStatusCode.Found, mapper.writeValueAsString(
                service.getById(id))
            )
        } ?: call.respond(HttpStatusCode.BadRequest)

    }

    // Additional routes can be configured here

}

/** Route to add a new book */
private fun Route.postBooksRoute() {
    post {

        val request: BookRequest = call.receive<BookRequest>()

        call.respond(
            when (service.save(request)) {
                true -> HttpStatusCode.Created
                false -> HttpStatusCode.UnprocessableEntity
            }
        )

    }
}

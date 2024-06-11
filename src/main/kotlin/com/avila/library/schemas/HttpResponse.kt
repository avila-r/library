/**
 * Data classes representing HTTP response schemas for the library application.
 */
package com.avila.library.schemas

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

/**
 * Serializable data class representing an HTTP response for exceptions.
 */
@Serializable
data class ExceptionHttpResponse (
    val code: Int,
    val status: String,
    val message: String
)

/**
 * Serializable data class representing an HTTP response for general results.
 */
@Serializable
data class HttpResultResponse (
    @Contextual
    val result: Any
)

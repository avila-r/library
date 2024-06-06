package com.avila

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {

    @Test
    fun testRoot() = testApplication {

        application {
            module()
        }

        val response = client.get("/")

        assertEquals(response.status, HttpStatusCode.OK)
        assertEquals(response.bodyAsText(), "Hello World!")

    }

}
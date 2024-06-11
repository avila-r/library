/**
 * Utility functions for obtaining customized JSON object mappers.
 */
package com.avila.library.utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule

import org.ktorm.jackson.KtormModule

/**
 * Returns a customized JSON object mapper with additional modules for handling Java time types and Ktorm entities.
 * @return Customized JSON object mapper.
 */
fun getCustomJsonObjectMapper(): ObjectMapper = JsonMapper.builder()
        .addModule(JavaTimeModule())
        .addModule(KtormModule())
        .build()

/**
 * Returns a default JSON object mapper without any additional modules.
 * @return Default JSON object mapper.
 */
fun getObjectMapper(): ObjectMapper = JsonMapper.builder().build()

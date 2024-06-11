package com.avila.library.config

import com.typesafe.config.ConfigFactory

import io.ktor.server.config.*

private object ApplicationConfig {

    val configurator: HoconApplicationConfig = HoconApplicationConfig(ConfigFactory.load())

    fun getConfigurator(): HoconApplicationConfig = configurator

}

fun getConfigurator(): HoconApplicationConfig = ApplicationConfig.getConfigurator()

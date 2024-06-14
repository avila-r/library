package com.avila.library.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource

import org.ktorm.database.Database

/**
 * Database connection singleton object that's able to set up database connection.
 */
object DatabaseFactory {

    private val config = getConfigurator()

    private val db: Database

    init {
        db = Database.connect(getDataSource())
    }

    /**
     * Retrieves database connection properties from the configuration.
     * @return Properties object containing the database connection details.
     */
    private fun getDataSource(): HikariDataSource = HikariDataSource (

        HikariConfig().apply {

            jdbcUrl = config.property("db.url").getString()
            driverClassName = config.property("db.driver").getString()
            username = config.property("db.user").getString()
            password = config.property("db.password").getString()
            maximumPoolSize = 10
            isAutoCommit = false
            transactionIsolation = "TRANSACTION_READ_COMMITTED"

        }

    )

    /**
     * Gets the database instance.
     * @return Database instance connected to the configured data source.
     */
    fun getDatabase(): Database = db

}

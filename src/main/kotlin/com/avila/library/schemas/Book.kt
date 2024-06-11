package com.avila.api.schemas

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.long

interface Book : Entity<Book> {
    val id: Long
    
}

object Books : Table<Book>("books") {

    val id = long("id").primaryKey().bindTo { it.id }

}

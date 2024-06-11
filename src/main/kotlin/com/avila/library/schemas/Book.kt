package com.avila.library.schemas

import org.ktorm.database.Database
import org.ktorm.entity.Entity
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.*

import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

/**
 * Interface representing the `Book` entity in the system.
 * Each book has various properties like title, author, ISBN, among others.
 */
interface Book : Entity<Book> {
    companion object : Entity.Factory<Book>()

    val id: Long
    val title: String
    val author: String
    val isbn: String
    val publicationDate: LocalDate
    val publisher: String
    val pages: Int
    val genre: String
    val summary: String
    val language: String
    val format: String
    val coverImageUrl: String
    val rating: Float
    val price: BigDecimal
    val availability: String
    val tags: List<String>
    val addedDate: LocalDateTime
    val location: String
}

/**
 * Object representing the `Books` table in the database.
 * Each column is mapped to a property of the `Book` interface.
 */
object Books : Table<Book>("books") {

    /**
     * The primary key of the book.
     */
    val id = long("id").primaryKey().bindTo { it.id }

    /**
     * The title of the book.
     */
    val title = varchar("title").bindTo { it.title }

    /**
     * The author of the book.
     */
    val author = varchar("author").bindTo { it.author }

    /**
     * The ISBN of the book.
     */
    val isbn = varchar("isbn").bindTo { it.isbn }

    /**
     * The publication date of the book.
     */
    val publicationDate = date("publication_date").bindTo { it.publicationDate }

    /**
     * The publisher of the book.
     */
    val publisher = varchar("publisher").bindTo { it.publisher }

    /**
     * The number of pages in the book.
     */
    val pages = int("pages").bindTo { it.pages }

    /**
     * The genre of the book.
     */
    val genre = varchar("genre").bindTo { it.genre }

    /**
     * The summary of the book.
     */
    val summary = varchar("summary").bindTo { it.summary }

    /**
     * The language of the book.
     */
    val language = varchar("language").bindTo { it.language }

    /**
     * The format of the book (e.g., Hardcover, Paperback).
     */
    val format = varchar("format").bindTo { it.format }

    /**
     * The URL of the book's cover image.
     */
    val coverImageUrl = varchar("cover_image_url").bindTo { it.coverImageUrl }

    /**
     * The rating of the book.
     */
    val rating = float("rating").bindTo { it.rating }

    /**
     * The price of the book.
     */
    val price = decimal("price").bindTo { it.price }

    /**
     * The availability status of the book.
     */
    val availability = varchar("availability").bindTo { it.availability }

    /**
     * The tags associated with the book.
     */
    val tags = text("tags").transform({ it.split(",") }, { it.joinToString(",") }).bindTo { it.tags }

    /**
     * The date the book was added to the system.
     */
    val addedDate = datetime("added_date").bindTo { it.addedDate }

    /**
     * The location of the book.
     */
    val location = varchar("location").bindTo { it.location }

}

/**
 * Extension property to access the sequence of books from the database.
 */
val Database.books get() = this.sequenceOf(Books)

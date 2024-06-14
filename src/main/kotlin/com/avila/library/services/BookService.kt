/**
 * Service interfaces and implementations related to book operations in the library application.
 */
package com.avila.library.services

import com.avila.library.schemas.Book
import com.avila.library.config.DatabaseFactory.getDatabase
import com.avila.library.schemas.Books
import com.avila.library.schemas.books

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import org.ktorm.dsl.eq
import org.ktorm.entity.*
import org.slf4j.LoggerFactory

/**
 * Interface defining operations for book management.
 */
interface BookServiceContract {
    suspend fun getAll(): List<Book>
    suspend fun getById(id: Long): Book?
    suspend fun save(book: Book)
    suspend fun delete(id: Long)
}

/**
 * Implementation of BookService interface for book management operations.
 */
class BookService : BookServiceContract {

    private val database = getDatabase()

    private val logger = LoggerFactory.getLogger("BookService")

    /**
     * Retrieves all books from the database.
     * @return List of all books in the database.
     */
    override suspend fun getAll(): List<Book> = withContext(Dispatchers.IO) {
        database
            .sequenceOf(Books)
            .toList()
    }

    /**
     * Retrieves a book by its ID from the database.
     * @param id The ID of the book to retrieve.
     * @return The book with the specified ID, or null if not found.
     */
    override suspend fun getById(id: Long): Book? = withContext(Dispatchers.IO) {
        this.runCatching {
            database.books.find { it.id eq id }
        }.onFailure {
            logger.error("Error while trying to get book by id: $id", it)
        }.getOrNull()
    }

    /**
     * Saves a new book to the database.
     * @param book The book object to save.
     */
    override suspend fun save(book: Book): Unit = withContext(Dispatchers.IO) {
        this.runCatching {
            database.books.add(book)
        }.onSuccess {
            logger.info("Saved book: $book")
        }.onFailure {
            logger.error("Error while trying to save book: $book", it)
        }
    }

    /**
     * Deletes a book from the database by its ID.
     * @param id The ID of the book to delete.
     */
    override suspend fun delete(id: Long): Unit = withContext(Dispatchers.IO) {
        this.runCatching {
            database.books.removeIf { it.id eq id }
        }.onSuccess {
            logger.info("Book with id $id deleted")
        }.onFailure {
            logger.error("Error while trying to delete book by id: $id", it)
        }
    }

}

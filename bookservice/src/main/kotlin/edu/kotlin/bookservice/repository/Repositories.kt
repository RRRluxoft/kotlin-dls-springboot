package edu.kotlin.bookservice.repository

import edu.kotlin.bookservice.model.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long> {
    fun findByIsbn(isbn: String): Book?
    fun findByBookId(bookId: Long): Book?
}
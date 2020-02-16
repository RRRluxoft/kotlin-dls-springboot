package edu.kotlin.bookservice.repository

import edu.kotlin.bookservice.model.Book
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
internal class RepositoriesTests @Autowired constructor(
    val entityManager: TestEntityManager,
    val bookRepo: BookRepository
    ){

    @Test
    fun `When findByIban then return Book`() {
        val book = Book(iban = "0101UUATest", author = "J.O.Dorsz", title = "One way")
        entityManager.persistAndFlush(book)

        val result: Book? = bookRepo.findByIban("0101UUATest")
        println("ALL : ${bookRepo.findAll()}")
        Assertions.assertSame(book, result, "Result is : $result")
    }
}
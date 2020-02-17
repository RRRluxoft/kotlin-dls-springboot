package edu.kotlin.bookservice

import edu.kotlin.bookservice.model.Book
import edu.kotlin.bookservice.repository.BookRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.support.beans
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.MediaType
import org.springframework.web.servlet.function.ServerResponse
import org.springframework.web.servlet.function.router

@SpringBootApplication
class BookCatalogueApplication

fun main(args: Array<String>) {
    runApplication<BookCatalogueApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)

        addInitializers(
            beans {
                bean("initRepoBean") {
                    val bookRepository = ref<BookRepository>()
                    ApplicationRunner {
                        bookRepository.deleteAll()
                        bookRepository.saveAll(
                            listOf(
                                Book("Peter M. Pirsig", "0-688-00230-7", "Zen and the Art of Motorcycle Maintenance"),
                                Book("Peter M. Pirsig", "0-688-00230-7", "Zen and the Art of Motorcycle Maintenance"),
                                Book("Peter M. Pirsig", "0-688-00230-7", "Zen and the Art of Motorcycle Maintenance"),
                                Book("Peter M. Pirsig", "0-688-00230-7", "Zen and the Art of Motorcycle Maintenance")
                            )
                        ).forEach { println(it) }

                    }
                }

                bean("routesBean") {
                    val bookRepository = ref<BookRepository>()
                    router {
                        (accept(MediaType.APPLICATION_JSON) and "/books" or "/").nest {

                            GET("/") { _ ->
                                ServerResponse.ok()
                                    .body(
                                        bookRepository.findAll(
                                            PageRequest.of(
                                                0, 2,
                                                Sort.by("isbn").ascending().and(Sort.by("author"))
                                            )
                                        )
                                    )
                            }
                            GET("/{id}") { request ->
                                ServerResponse.ok().body(
                                    bookRepository.findByBookId(request.pathVariable("id").toLong())
                                        ?: bookRepository.findAll()
                                )
                            }
                        }
                    }
                }

            }
        )
    }
}
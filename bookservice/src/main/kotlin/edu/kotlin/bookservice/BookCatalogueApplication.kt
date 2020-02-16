package edu.kotlin.bookservice

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookCatalogueApplication

fun main(args: Array<String>) {
    runApplication<BookCatalogueApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}
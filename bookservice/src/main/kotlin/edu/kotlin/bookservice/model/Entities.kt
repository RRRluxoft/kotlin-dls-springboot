package edu.kotlin.bookservice.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Book(
    var author: String = "",
    var iban: String = "",
    var title: String = "",
    @Id @GeneratedValue var bookId: Long? = null
)
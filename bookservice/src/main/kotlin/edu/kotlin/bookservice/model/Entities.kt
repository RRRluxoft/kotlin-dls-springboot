package edu.kotlin.bookservice.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Book(
    val author: String = "",
    val isbn: String = "",
    val title: String = "",
    @Id @GeneratedValue val bookId: Long? = null
)
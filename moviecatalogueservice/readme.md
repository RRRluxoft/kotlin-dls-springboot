Created by rlytvyshko on 2/17/2020

This is a concept file with following syntax for each concept.
# Concept Heading
* step1
* step2

Develop a movies catalogue REST API. Treat it as a backend part of streaming service UI. The API should provide the functionality to cover the following scenarios:

Return the movies (lightweight version of data) in catalogue page by page
Search movies by name
Support sorting by different fields
View movie’s detailed information
Add new movie
View user’s profile
View user’s balance in USD
Add some value to the balance (we do not require it to be secure, just make an ability to top up the balance)
View user’s orders
Order the movie (make sure that user’s balance is decreased by the defined amount)
The REST API endpoints structure could be implemented like this:
/movies
/movies/{id}
/users/
/users/{id}/profile
/users/{id}/orders
/users/{id}/orders/{id}
/users/{id}/balance

However, the final API design is up to you. Use the best practices to design the REST API contract.

We do not require to implement any kind of UI during this task. Highly recommended to embed Swagger UI for testing purposes.

Task Requirements
Use only Kotlin as a development language. Try to wisely apply Kotlin idioms in proper places
Use Kotlin DSL instead of other types of configuration to define the Spring beans.
Use Gradle with Kotlin DSL as a build tool.
Cover the code by unit tests using JUnit 5
For logging it is recommended to use KotlinLogging
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "edu.kotlin"
version = "1.0.0"


plugins {
    kotlin("jvm") // version kotlinVersion
    id("org.springframework.boot") // version springBootVersion
    id("io.spring.dependency-management") //version "1.0.8.RELEASE"
    kotlin("plugin.spring") // version kotlinVersion
    kotlin("plugin.jpa") // version kotlinVersion
    kotlin("plugin.allopen") //version kotlinVersion
    kotlin("plugin.noarg") //version kotlinVersion
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}

repositories {
    mavenCentral()
}

subprojects {
    group = "edu.kotlin"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
//    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-mustache")
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}
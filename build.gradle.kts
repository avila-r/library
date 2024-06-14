import org.jetbrains.kotlin.gradle.dsl.JvmTarget

val kotlinVersion: String by project
val logbackVersion: String by project
val ktormVersion: String by project
val postgresVersion: String by project
val slf4jVersion: String by project
val hikariVersion: String by project
val ktorVersion: String by project

plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    kotlin("jvm") version "1.9.24"
    id("io.ktor.plugin") version "2.3.11"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.24"
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

group = "com.avila"
version = "0.0.1"

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
        jvmTarget = JvmTarget.JVM_21
    }
}

application {
    mainClass.set("com.avila.library.ApplicationKt")
}

tasks.shadowJar {
    manifest {
        attributes["Main-Class"] = "com.avila.library.ApplicationKt"
    }
}

repositories {
    mavenCentral()
}

dependencies {

    /*
     * Ktor dependencies
     */

        // core
        implementation("io.ktor:ktor-server-status-pages:$")
        implementation("io.ktor:ktor-server-core-jvm")
        implementation("io.ktor:ktor-server-netty-jvm")

        // Serialization
        implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$")
        implementation("io.ktor:ktor-serialization-jackson-jvm:$ktorVersion")
        implementation("org.ktorm:ktorm-jackson:3.6.0")

        // Docs
        implementation("io.ktor:ktor-server-openapi:$ktorVersion")
        implementation("io.ktor:ktor-server-swagger:$ktorVersion")
        implementation("io.swagger.codegen.v3:swagger-codegen-generators:1.0.36")

    /*
     * Database
     */
        implementation("org.ktorm:ktorm-support-postgresql:$ktormVersion")
        implementation("org.postgresql:postgresql:$postgresVersion")
        implementation("org.ktorm:ktorm-core:$ktormVersion")
        implementation("com.zaxxer:HikariCP:$hikariVersion")

    /*
     * Miscellaneous
     */
        implementation("ch.qos.logback:logback-classic:$logbackVersion")

    /*
     * Logging
     */
        implementation("org.slf4j:slf4j-api:$slf4jVersion")
        implementation("org.slf4j:slf4j-simple:$slf4jVersion")

    /*
     * Tests
     */
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
        testImplementation("io.ktor:ktor-server-tests-jvm")

}

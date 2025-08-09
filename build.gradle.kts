val parchmentVersion: String by project
val edenApiVersion: String by project

plugins {
    `java-library`
}

group = "gg.projecteden"
version = "1.0-SNAPSHOT"
description = "Nexus, but Paper. Solely for interacting with Paper Plugin specific APIs"

repositories {
    mavenLocal {
        content {
            includeGroup("gg.projecteden")
            includeGroup("net.coreprotect")
        }
    }
    mavenCentral()
    maven { url = uri("https://sonatype.projecteden.gg/repository/maven-public/") }
    maven { url = uri("https://repo.papermc.io/repository/maven-public/") }
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.8-R0.1-SNAPSHOT")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks {
    compileJava {
        options.release = 21
    }
    javadoc {
        options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything
    }
}

tasks.test {
    useJUnitPlatform()
}
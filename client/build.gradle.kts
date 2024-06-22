plugins {
    id("org.springframework.boot") version "3.3.1"
    id("io.spring.dependency-management") version "1.1.5"
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.spring") version "1.9.24"
    `maven-publish`
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.example"
            artifactId = "client"
            version = "0.0.24-SNAPSHOT"

            from(components["java"])
        }
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

dependencies {
    implementation("org.springframework.kafka:spring-kafka")
    implementation("org.springframework.boot:spring-boot-starter")
    annotationProcessor("org.springframework.boot:spring-boot-autoconfigure-processor")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}
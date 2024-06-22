package com.example.clientexecutetest

import com.example.clienttest.MessageClient
import com.example.clienttest.config.ClientProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment

@SpringBootApplication
class ClientExecuteTestApplication

fun main(args: Array<String>) {
    runApplication<ClientExecuteTestApplication>(*args)
}


@Configuration
class TestConfiguration {
    @Bean
    fun test(messageClient: MessageClient,
             environment: Environment,
             clientProperties: List<ClientProperties>) : String {

        environment.acceptsProfiles { it.test("local") }
        return "asdf"
    }
}
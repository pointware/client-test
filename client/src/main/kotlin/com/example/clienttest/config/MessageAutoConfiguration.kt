package com.example.clienttest.config

import com.example.clienttest.MessageClient
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment

@Configuration
class MessageAutoConfiguration(
    val environment: Environment
) {

    @Bean
    @ConditionalOnMissingBean(ClientProperties::class)
    fun setupClientProperties(): ClientProperties {
        val clientProperties = ClientProperties()
        if (environment.acceptsProfiles { it.test("local") }) {
            clientProperties.producer.bootstrapServers = listOf("localhost")
        } else if (environment.acceptsProfiles { it.test("dev") }) {
            clientProperties.producer.bootstrapServers = listOf("dev")
        }
        return clientProperties
    }

    @Bean
    fun messageClient(): MessageClient {
        val clientProperties = setupClientProperties()
        println("messageClient${clientProperties.producer.buildProperties(null)}")
        println("interval${clientProperties.interval}")
        return MessageClient(clientProperties)
    }

}
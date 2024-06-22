package com.example.clienttest.config

import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "message")
class ClientProperties(
    var producer: KafkaProperties.Producer = KafkaProperties.Producer().apply {
        this.properties["retry.backoff.ms"] = "1000"
    },
    var interval: String = "3"
)
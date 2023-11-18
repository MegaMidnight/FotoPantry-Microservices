package com.fotopantry.fotopantrymediaupload.config

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig {

    @Value("\${RABBITMQ_HOST:localhost}")
    private lateinit var host: String

    @Value("\${RABBITMQ_PORT:5672}")
    private var port: Int = 0

    @Value("\${RABBITMQ_DEFAULT_USER:guest}")
    private lateinit var username: String

    @Value("\${RABBITMQ_DEFAULT_PASS:guest}")
    private lateinit var password: String

    // ...


    /**
     * Creates and configures a CachingConnectionFactory for RabbitMQ.
     *
     * The CachingConnectionFactory is a wrapper for the RabbitMQ ConnectionFactory.
     * The host, port, username, and password for the RabbitMQ server are injected from environment variables.
     * These values are used to configure the CachingConnectionFactory.
     *
     * @return A CachingConnectionFactory configured with the RabbitMQ connection details.
     */
    @Bean
    fun connectionFactory(): CachingConnectionFactory {
        val connectionFactory = CachingConnectionFactory(host, port)
        username?.let { connectionFactory.username = it } // connectionFactory.setUsername(username) with null check
        password?.let { connectionFactory.setPassword(it) } // connectionFactory.setPassword(password) with null check
        return connectionFactory
    }
}
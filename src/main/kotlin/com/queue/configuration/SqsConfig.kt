package com.queue.configuration

import com.amazon.sqs.javamessaging.ProviderConfiguration
import com.amazon.sqs.javamessaging.SQSConnectionFactory
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration
import com.amazonaws.services.sqs.AmazonSQS
import com.amazonaws.services.sqs.AmazonSQSAsyncClient
import jakarta.jms.Session
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jms.annotation.EnableJms
import org.springframework.jms.config.DefaultJmsListenerContainerFactory
import org.springframework.jms.support.destination.DynamicDestinationResolver


@Configuration
@EnableJms
class SqsConfig {

    @Bean
    fun createConnectionFactory(): SQSConnectionFactory {
        return SQSConnectionFactory(ProviderConfiguration(), sqsClient())
    }
    @Bean
    fun sqsClient(): AmazonSQS {
        val sqsExtendedBuilder = AmazonSQSAsyncClient.asyncBuilder()
        return sqsExtendedBuilder
            .withEndpointConfiguration(EndpointConfiguration("http://localhost:4566", "us-east-1"))
            .withCredentials(
                AWSStaticCredentialsProvider(
                    BasicAWSCredentials("dev", "dev")
                )
            ).build()
    }

    @Bean
    fun jmsListenerContainerFactory(): DefaultJmsListenerContainerFactory? {
        val factory = DefaultJmsListenerContainerFactory()
        factory.setDestinationResolver(DynamicDestinationResolver())
        factory.setConnectionFactory(createConnectionFactory())
        factory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE)
        factory.setAutoStartup(true)
        return factory
    }
}

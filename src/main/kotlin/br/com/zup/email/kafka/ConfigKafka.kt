package br.com.zup.email.kafka

import br.com.zup.email.kafka.dto.TransacaoInput
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@Configuration
class ConfigKafka(
    private val kafkaProperties: KafkaProperties
) {

    @Bean
    fun consumerConfiguration(): Map<String, Any> {
        return mapOf(
            Pair(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.bootstrapServers),
            Pair(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, kafkaProperties.consumer.keyDeserializer),
            Pair(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, kafkaProperties.consumer.valueDeserializer),
            Pair(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.consumer.groupId)
        )
    }

    @Bean
    fun transactionConsumerFactory(): ConsumerFactory<String, TransacaoInput> {
        return DefaultKafkaConsumerFactory(
            consumerConfiguration(),
            StringDeserializer(),
            JsonDeserializer(Any::class.java, false)
        )
    }

    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, TransacaoInput> {
        return ConcurrentKafkaListenerContainerFactory<String, TransacaoInput>().apply {
            setConsumerFactory(transactionConsumerFactory())
        }
    }
}


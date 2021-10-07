package br.com.zup.email.kafka

import br.com.zup.email.kafka.dto.TransacaoInput
import br.com.zup.email.service.AcaoPosInput
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class ConsumerKafka(
    private val acoesPosInput: List<AcaoPosInput>
) {

    private val logger = LoggerFactory.getLogger(ConsumerKafka::class.java)

    @KafkaListener(
        topics = ["\${kafka.consumer.topic}"],
        groupId = "\${spring.kafka.consumer.group-id}"
    )
    fun consume(input: TransacaoInput) {
        logger.info(input.toString())
        acoesPosInput.forEach { acao -> acao.processar(input) }
    }
}
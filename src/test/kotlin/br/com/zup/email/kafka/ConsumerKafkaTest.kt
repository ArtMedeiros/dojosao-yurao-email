package br.com.zup.email.kafka

import br.com.zup.email.repository.TransacaoRepository
import br.com.zup.email.kafka.dto.TransacaoInput
import br.com.zup.email.kafka.util.Operacao
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.math.BigDecimal
import java.time.LocalDateTime
import org.junit.jupiter.api.Assertions.*

@SpringBootTest
internal class ConsumerKafkaTest(
    @Autowired val consumerKafka: ConsumerKafka,
    @Autowired val repository: TransacaoRepository
) {

    lateinit var transacaoInput: TransacaoInput

    @BeforeEach
    fun setup() {
        transacaoInput = TransacaoInput(
            operacao = Operacao.PAGAMENTO_BOLETO,
            valor = BigDecimal(50.0),
            dataTransacao = LocalDateTime.now(),
            idCliente = 1,
            idConta = 1
        )
    }

    @Test
    fun `deve salvar a transacao`() {
        consumerKafka.consume(transacaoInput)

        repository.findAll().let {
            assertEquals(1, it.size)
        }
    }
}
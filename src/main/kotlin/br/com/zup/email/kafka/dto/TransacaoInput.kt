package br.com.zup.email.kafka.dto

import br.com.zup.email.kafka.util.Operacao
import br.com.zup.email.model.Transacao
import java.math.BigDecimal
import java.time.LocalDateTime

data class TransacaoInput(
    val operacao: Operacao,
    val valor: BigDecimal,
    val dataTransacao: LocalDateTime,
    val idCliente: Long,
    val idConta: Long
) {

    fun toTransacao(): Transacao {
        return Transacao(
            operacao = operacao,
            valor = valor,
            dataTransacao = dataTransacao,
            idCliente = idCliente,
            idConta = idConta
        )
    }
}
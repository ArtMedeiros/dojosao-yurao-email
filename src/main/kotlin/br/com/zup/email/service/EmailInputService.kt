package br.com.zup.email.service

import br.com.zup.email.kafka.dto.TransacaoInput
import org.springframework.stereotype.Service

@Service
class EmailInputService : AcaoPosInput {
    override fun processar(input: TransacaoInput) {
        enviarEmail(input)
    }

    private fun enviarEmail(input: TransacaoInput) {
        println("Enviando email para ${input.idCliente}")
        println("Valor da transacao ${input.valor}")
        println("Transacao realizada ${input.operacao}")
    }
}
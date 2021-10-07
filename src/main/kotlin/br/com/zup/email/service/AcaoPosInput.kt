package br.com.zup.email.service

import br.com.zup.email.kafka.dto.TransacaoInput

interface AcaoPosInput {
    fun processar(input: TransacaoInput)
}
package br.com.zup.email.service

import br.com.zup.email.repository.TransacaoRepository
import br.com.zup.email.kafka.dto.TransacaoInput
import org.springframework.stereotype.Service
import org.springframework.transaction.support.TransactionTemplate

@Service
class PersistirInputService(
    private val repository: TransacaoRepository,
    private val transaction: TransactionTemplate
) : AcaoPosInput {
    override fun processar(input: TransacaoInput) {
        input.run {
            transaction.execute {
                repository.save(toTransacao())
            }
        }
    }
}
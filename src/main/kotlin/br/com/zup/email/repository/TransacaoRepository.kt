package br.com.zup.email.repository

import br.com.zup.email.model.Transacao
import org.springframework.data.jpa.repository.JpaRepository

interface TransacaoRepository : JpaRepository<Transacao, Long> {
}
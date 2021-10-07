package br.com.zup.email.model

import br.com.zup.email.kafka.util.Operacao
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*
import javax.persistence.EnumType.*
import javax.persistence.GenerationType.SEQUENCE
import javax.validation.constraints.NotNull

@Entity
class Transacao(
    @field:NotNull
    @field:Enumerated(STRING)
    val operacao: Operacao,

    @field:NotNull
    val valor: BigDecimal,

    @field:NotNull
    val dataTransacao: LocalDateTime,

    @field:NotNull
    val idCliente: Long,

    @field:NotNull
    val idConta: Long
) {

    @Id @GeneratedValue(strategy = SEQUENCE)
    val id: Long? = null
}
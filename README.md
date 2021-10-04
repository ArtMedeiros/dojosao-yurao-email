# Email

O serviço de email é, basicamente, um serviço de notificação. A sua função é ficar escutando um tópico no _Kafka_ para saber quais as transações que aconteceram e enviar um email para as pessoas que são donas das contas.

A tarefa para esse serviço é basicamente a seguinte:
1. Enviando um email com a transação

---

## Enviando um email com os dados de uma transação

### Necessidades

Sempre que um usuário realiza uma transação o serviço **Orquestrador** envia uma mensagem para um tópico chamado `transacoes` no Kafka. Nossa missão é ouvir essa transação nesse tópico e enviar um email para a pessoa dona da conta.
   
### Restrições

- Só podemos enviar um email para a pessoa por cada transação.


### Resultado Esperado

- O email salvo no banco de dados com a data e hora de envio
- O email seja enviado (No nosso cenário, apenas imprimir um Log na tela está válido)



### Desafio
Olá, queremos convidá-lo(a) a participar do nosso desafio de seleção.  Pronto(a) para participar? Seu trabalho será visto pelo nosso time e você receberá um feedback ao final sobre o que achamos do seu trabalho. Não é legal?

### Sobre a oportunidade 
A vaga é para Desenvolvedor(a), temos vagas com diversos níveis de senioridade e para cada um deles utilizaremos critérios específicos considerando este aspecto, combinado? 
Se você for aprovad(a) nesta etapa, será convidado para uma entrevista final.

### Desafio Técnico
  Nós trabalhamos com meios de pagamento e nada melhor do que um bom sistema para gestão de contas:
  
  - Pré-requisitos:
    ```
    * Desenvolver os recursos em API Rest que realizam operações bancárias com a entidade conta a seguir:
    ```
    | Contas | Tipo |
    |-|-|
    | idConta | Numérico |
    | idPessoa | Numérico |
    | saldo | Monetário |
    | limiteSaqueDiario | Monetário |
    | flagAtivo | Condicional |
    | tipoConta | Numérido |
    | dataCriacao | Data |

    ```
    * Tabela de transações realizadas na conta
    ```
    | Transacoes | Tipo |
    |-|-|
    | idTransacao | Numérico |
    | idConta | Numérico |
    | valor | Monetário |
    | dataTransacao | Data |

    ```
    * P.S.: Não é necessário realizar operações com a tabela pessoa, mas é necessária a criação da tabela para mapeamento da relação com a conta e enviar script de criação de pelo menos uma pessoa.
    ```

    | Pessoas | Tipo |
    |-|-|
    | idPessoa | Numérico |
    | nome | Texto |
    | cpf | Texto |
    | dataNascimento | Data |    

  - O que esperamos como escopo mínimo:
    ```
    * Implementar path que realiza a criação de uma conta;
    * Implementar path que realiza operação de depósito em uma conta;
    * Implementar path que realiza operação de consulta de saldo em determinada conta;
    * Implementar path que realiza operação de saque em uma conta;
    * Implementar path que realiza o bloqueio de uma conta;
    * Implementar path que recupera o extrato de transações de uma conta;
    ```
  - O que será diferencial:
    ```
    * Implementar extrato por período;
    * Elaborar manual de execução;
    * Elaborar documentação;
    * Elaborar testes.
    ```
    
  - O que vamos avaliar:
    ```
    * Seu código; 
    * Dockerfile ou docker-compose do serviço;
    * Script de banco;
    * Organização;
    * Boas práticas;
    * Diferenciais; 
    ```

  - Teste para o time de Arquitetura? 
    ```
    * Baseado no que foi desenvolvido nos envie uma solução da Arquitetura utilizando serviços na nuvem como a AWS (diferencial), Azure e GCP;
    * Junto com as instruções de execução, explique qual Design Pattern você utilizou e por que o escolheu para a sua solução.
    ```
  

### Instruções
      1. Faça o fork do desafio;
      2. Crie um repositório privado no seu github para o projeto e adicione como colaborador o usuário wesleyjoliveira;
      3. Desenvolva. Você terá 7 (sete) dias a partir da data do envio do desafio; 
      4. Após concluir seu trabalho faça um push; 
      5. Envie um e-mail à pessoa que está mantendo o contato com você durante o processo notificando a finalização do desafio para validação.


=======>>>>

Para rodar o projeto:
 
 mvn clean package spring-boot:repackage
 mvn clean install
 mvn spring-boot:run
 
 
# Prova Java

## Desenvolvimento

* 1 - Cadastro de Campanha - campanha-service
* 2 - Cadastro de Socio torcedor - socioTorcedor-service
* 3 - Resolucao do exercicio do stream de chars - stream


Ambos os projetos de serviços foi feito usando spring boot, com padrao de camadas (service/dao), dependecy injection, foi usado tratamento de exceção e criação de objetos request/response principalmente para os servicos acessados pelo socioTorcedor.

Para rodar cada um dos servicos, executar o Application.java

No caso do SocioTorcedor, ele tem um properties na pasta raiz do projeto para ajuste da porta do servidor e do endereco do serviço de campanha.

Para os testes foi usado o postman. 

Existe um servico para cadastrar uma lista de campanhas e popular a base de dados (em memória). Essa lista esta na pasta raiz do repositorio (teste-java1) popula_campanha.json e um arquivo socioTorcedor.json com um exemplo de entrada de socio torcedor.


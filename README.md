# Prova Java

## Desenvolvimento

* 1 - Cadastro de Campanha - campanha-service
* 2 - Cadastro de Socio torcedor - socioTorcedor-service
* 3 - Resolucao do exercicio do stream de chars - stream



### 4 - O que é Deadlock? Detalhe um pouco sobre o caso e como você poderia resolver isso.

É quando dois ou mais processos ou threads tentam usar um recurso que esta sendo usado por algum outro processo

Esse problema pode ser resolvido ou amenizado com o uso de semaforos. 
No caso do java com o uso da da declaracao "syncronized" nos metodos que podem causar um deadlock, essa declaracao controla a concorrencia nos recursos do metodo. 
Porém não é usada a todo momento, em ambientes single-threaded pois pode onerar o desempenho do sistema. 

Para evitar um deadlock podemos "reservar" todos os recursos que a aplicação irá usar antes de começar o processo. Porém isso pode ser bastante custoso para a máquina além de deixar todos os outros processos esperando perdendo um pouco da ideia de processamento paralelo.


### 5 - Uma das grandes inclusões no Java 8 foi a API Stream. Com ela podemos fazer diversas operações de loop, filtros, maps, etc. Porém, existe uma variação bem interessante do Stream que é ParallelStreams. Descreva com suas palavras quando qual é a diferença entre os dois e quando devemos utilizar cada um deles.

O stream e o parallelStream fazem a mesma coisa do mesmo jeito para quem está escrevendo o codigo. 
A grande diferenca entre eles é que o stream é sigle-thread e o parallelStream "espalha" o processamento daquela lista para todos os processadores disponiveis executando a operação em paralelo. 
  
Devemos utilizar o parallelStream stream quando temos que lidar com listas muito pesadas, com grande quantidade de dados. E o stream pode ser usado como substituto do tradicional for. 
# ROTAS-KOTLIN
<p>Avaliador da melhor rota entre dois pontos, considerando-se o menor custo</p>
<p>Copyright © 2020 Richardson Software Ltda.</p>

## Introdução

Essa aplicação tem o intuito de buscar a rota mais barata, entre dois pontos, independentemente da quantidade de pontos intermediários.

O problema gerador dessa solução aduz que um viajante deseja ir de uma origem a um destino, pagando o menor valor possível, não importando a quantidade de escalas que venha a passar.

Trata-se de uma abordagem pessoal do famoso algoritmo criado por Edsger Djisktra, em 1956 (publicado em 1959), utilizando-se somente de Listas e Mapas Java.

Para maiores informações acerca do Algoritmo de Djikstra, acesse [http://www.inf.ufsc.br/grafos/temas/custo-minimo/dijkstra.html](http://www.inf.ufsc.br/grafos/temas/custo-minimo/dijkstra.html).

Para uma implementação Java do mesmo, acesse [https://www.baeldung.com/java-dijkstra](https://www.baeldung.com/java-dijkstra).  

## Tecnologias Utilizadas

* Kotlin;
* Spring Boot;
* Maven;
* REST;

## Operações REST

* **Recuperar Rotas:**

  Essa operação realiza a busca pelas rotas cadastradas inicialmente.

  * **Endpoint:** /rotas
  * **Método:** GET
  * **Consumo Local:**
    ```
    curl -X GET "http://localhost:8080/rotas" -H "accept: application/json"
    ```
  * **Response:** Listagem de Rotas
  * **Exemplo de Resposta:**
    ```javascript
    [
      {
        "origem": "GRU",
        "destino": "BRC",
        "custo": 10
      },
      {
        "origem": "BRC",
        "destino": "SCL",
        "custo": 5
      },
      {
        "origem": "GRU",
        "destino": "CDG",
        "custo": 75
      },
      {
        "origem": "GRU",
        "destino": "SCL",
        "custo": 20
      },
      {
        "origem": "GRU",
        "destino": "ORL",
        "custo": 56
      },
      {
        "origem": "ORL",
        "destino": "CDG",
        "custo": 8
      },
      {
        "origem": "SCL",
        "destino": "ORL",
        "custo": 20
      },
      {
        "origem": "BRC",
        "destino": "CDG",
        "custo": 35
      }
    ]
    ```

* **Recuperar Melhor Rota:**

  Essa operação realiza a busca pela rota mais barata, entre uma origem e um destino, a partir das rotas cadastradas inicialmente.

  * **Endpoint:** /melhor-rota?origem=ORI&destino=DES
  * **Método:** GET
  * **Parâmetros:**
    * **origem:** local de origem da rota. Exemplo: origem=GRU
    * **destino:** local de destino da rota. Exemplo: destino=CDG
  * **Consumo Local:**
    ```
    curl -X GET "http://localhost:8080/melhor-rota?origem=GRU&destino=CDG" 
    -H "accept: application/json"
    ```
  * **Response:** String com a melhor rota encontrada
  * **Exemplo de Resposta:**
    ```javascript
    GRU - BRC - SCL - ORL - CDG
    ```

## Modelo de Dados:

* **Rota:**
  ```javascript
  {
    "origem": "String",
    "destino": "String",
    "custo": Integer
  }
  ```

## Execução em Nuvem

* As operações REST podem ser acessadas pela URL [https://rotas-kotlin.herokuapp.com/](https://rotas-kotlin.herokuapp.com/)
* Será apresentado o swagger da aplicação

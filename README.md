
# Star Wars Resistence Social Network
API REST com Java e Spring Boot, processo seletivo **Phoebus Tecnologia**.

*"O império continua sua luta incessante de dominar a galáxia, tentando ao máximo expandir seu território e eliminar os rebeldes. Você, como um soldado da resistência, foi designado para desenvolver um sistema para compartilhar recursos entre o rebeldes."*

## Requisitos
- IDE Eclipse, Netbeans e Afins
- Maven

**Recomendações**
- Localhost<br/>
A API roda na porta 8080, caso ela esteja ocupada, basta entrar no arquivo `application.properties` nas pasta resources e atribuir um novo valor na linha que contem `server.port=NOVO VALOR` 

- Postman<br/>
Testa serviços RESTful (Web APIs) por meio do envio de requisições HTTP

## Endpoints

- **Adicionar rebelde**<br/>
Um rebelde é adicionado juntamente com sua localização e seu inventário.<br/>
Cada item do inventário tem uma pontuação fixa, a qual é multiplicada automaticamente pela quantidade do mesmo item. Segue a lista de itens disponíveis:

Item | Pontos
------------ | -------------
1 Arma | 4 Pontos
1 Munição | 3 Pontos
1 Água | 2 Pontos
1 Comida | 1 Pontos

Os itens que não contém nesta lista ou estão escritos de forma diferente são cadastrados automaticamente como **`Lixo`** com sua quantidade e seus pontos zerados.<br/>
**OBS**: Seus itens devem ser declarados quando o rebelde se cadastradar no sistema. Após isso seu inventário só poderá mudar através de negociação com outros rebeldes.<br/>

Método **POST**: localhost:8080/rebelde
```json
{
    "nome" : "Rebelde Z",
    "idade" : 28,
    "genero" : "F",
    "localizacao" : {
        "latitude" : "-7.1185908",
        "longitude" : "-30.8406991",
        "galaxia" : "Brasil"
    },
    "inventario" : {
        "itens" : [
            {
                "nome" : "Arma",
                "qtd" : 1
            },
            {
                "nome" : "Munição",
                "qtd" : 0
            },
            {
                "nome" : "Água",
                "qtd" : 5
            },
            {
                "nome" : "Comida",
                "qtd" : 3
            }
        ]	
    }
}
```

- **Atualizar localização do rebelde**<br/>
Um rebelde possuir a capacidade de reportar sua última localização, armazenando a nova latitude, longitude, galaxia.<br/>
Na URL é passado o **`id`** do rebelde como seu identificador.<br/><br/>
Método **PUT**: localhost:8080/localizacao/reportar/**`id`**
```json
{
    "latitude" : "-6.45678",
    "longitude" : "-34.12348",
    "galaxia" : "Brasil"
}
```

- **Buscar rebelde**<br/>
Retorna todas as informações referentes a um rebelde especifico.<br/><br/>
Na URL é passado como parâmetro  o número correspondente ao **`id`** do rebelde.<br/>
Método **GET**: localhost:8080/rebelde?id=**`id`**
```json
{
    "id": 1,
    "nome": "Rebelde Z",
    "idade": 28,
    "genero": "F",
    "localizacao": {
        "id": 14,
        "latitude": "-6.45678",
        "longitude": "-34.12348",
        "galaxia": "Brasil"
    },
    "inventario": {
        "id": 1,
        "itens": [
            {
                "id": 1,
                "nome": "Arma",
                "qtd": 1,
                "pontos": 4
            },
            {
                "id": 2,
                "nome": "Munição",
                "qtd": 0,
                "pontos": 6
            },
            {
                "id": 3,
                "nome": "Água",
                "qtd": 5,
                "pontos": 10
            },
            {
                "id": 4,
                "nome": "Comida",
                "qtd": 3,
                "pontos": 3
            }
        ]
    }
}
```

- **Negociar itens**<br/>
Os rebeldes poderão negociar itens entre eles. Para isso, eles devem respeitar a tabela de preços citada acima, onde o valor do item é descrito em termo de pontos. Ambos os lados deverão oferecer a mesma quantidade de pontos. Por exemplo, 1 munição e 1 comida (1 x 3 + 1 x 1) valem 2 águas (2 x 2) ou 4 comidas (4 x 1). <br/>
Caso os *nomes dos itens estejam diferente da tebela de preços*, a *quantidade de itens seja maior que o inventário do rebelde* ou *a pontuação não bata* o trade será **CANCELADO**

**OBS**: A negociação em si não será armazenada, mas os itens deverão ser transferidos de um rebelde a outro.

Método **POST**: localhost:8080/rebelde/trade
```json
[
    {
        "idRebelde" : 1,
        "itens" : [
            {
                "nome": "Munição",
                "qtd": 1
            },
            {
                "nome": "Comida",
                "qtd": 1
            }
        ]
    },
    {
        "idRebelde" : 8,
        "itens" : [
            {
                "nome": "Água",
                "qtd": 2
            }
        ]
    }
]
```

## Descrição 
- Sistema de venda de ingressos utilizando OpenFeign para a comunicação entre os microsserviços.

## Endpoints
### Times:
**Get:** 
- /api-times/search/
- /api-times/search/by-name/{name}
- /api-times/search/by-city/{city}
- /api-times/search/by-state/{st}

**Post:**
- /api-times/create

  Exemplo de payload:
  
```
  {
    "fullname": "string",
    "knownname": "string",
    "nickname": "string",
    "fansname": "string",
    "city": "string",
    "state": "st",
    "stadium": "string"
  }
```

**Put:**
- /api-times/edit/{id}

  Exemplo de payload:
  
```
  {
    "fullname": "string",
    "knownname": "string",
    "nickname": "string",
    "fansname": "string",
    "city": "string",
    "state": "st",
    "stadium": "string"
  }
```
**Delete:**
- /api-times/delete/{id}
### Torcedores
**Get:**
/ingressos/historico/{email}

**Get:**  
- /torcedores
- /torcedores/{id}

**Post:**
- /torcedores

  Exemplo de payload:
  
```
{
  "nome": "string",
  "email": "string@email.com"
}
```

**Put:**
- /torcedores/{id}

  Exemplo de payload:
  
```
  {
    "nome": "string",
    "email": "string@email.com"
  }
```
**Delete:**
- /torcedores/{id}
### Jogos
**Get:**  
- /jogos
- /jogos/{id}
- /jogos/buscar-por-data?dataHora={localDate}

**Post:**
- /jogos

  Exemplo de payload:
  
```
{
  "timeCasa": "Fluminense",
  "timeVisitante": "Flamengo",
  "estadio": "Maracana",
  "precoIngresso": 200.0,
  "dataHora": "2024-12-21T18:00:00"
}
```

**Put:**
- /jogos/{id}

  Exemplo de payload:
  
```
  {
    "timeCasa": "Fluminense",
    "timeVisitante": "Flamengo",
    "estadio": "Maracana",
    "precoIngresso": 200.0,
    "dataHora": "2024-12-21T18:00:00"
  }
```
**Delete:**
- /jogos/{id}



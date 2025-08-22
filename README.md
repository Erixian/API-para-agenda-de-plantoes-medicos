
# Java RESTful API para agenda de plantoes medicos

## Diagrama de classes:
```mermaid

classDiagram
    class Medico {
        +crm: string
        +nome: string
        +plantoes: Plantao[]  # Relação N-N
    }

    class Plantao {
        +id: int
        +horaInicio: Date
        +horaFim: Date
        +medicos: Medico[]  # Relação N-N
        +hospital: Hospital  # Relação N-1
    }

    class Hospital {
        +id: int
        +nome: string
        +endereco: string
        +plantoes: Plantao[]  # Relação 1-N
    }

    Medico "n" -- "n" Plantao 
    Hospital "1" -- "n" Plantao 

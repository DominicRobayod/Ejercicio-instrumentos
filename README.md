# Diagrama UML – Patrón Composite aplicado a un sistema musical

```mermaid
classDiagram
    %% Clase base abstracta
    class Musical {
        <<abstract>>
        +tocar(): void
        +afinar(): void
        +add(m: Musical)
        +remove(m: Musical)
        +getChildren(): List
        +getNombre(): String
    }

    %% Clase hoja
    class Instrumento {
        -nombre : String
        +Instrumento(nombre: String)
        +tocar(): void
        +afinar(): void
        +getNombre(): String
    }

    %% Clase composite
    class GrupoMusical {
        -nombre : String
        -hijos : List
        +GrupoMusical(nombre: String)
        +tocar(): void
        +afinar(): void
        +add(m: Musical)
        +remove(m: Musical)
        +getChildren(): List
        +getNombre(): String
    }

    %% Subgrupos concretos
    class Percusion {
        +Percusion()
        --
        "Batería, Congas, Bongós"
    }
    class Cuerdas {
        +Cuerdas()
        --
        "Guitarra, Violín, Arpa"
    }
    class Vientos {
        +Vientos()
        --
        "Flauta, Saxofón, Trompeta"
    }

    %% Herencia
    Musical <|-- Instrumento
    Musical <|-- GrupoMusical
    GrupoMusical <|-- Percusion
    GrupoMusical <|-- Cuerdas
    GrupoMusical <|-- Vientos

    %% Agregación
    GrupoMusical o-- "0..*" Musical : hijos

    %% Relaciones entre subgrupos
    Percusion -- Cuerdas : relacionada
    Percusion -- Vientos : relacionada
    Cuerdas -- Vientos : relacionada

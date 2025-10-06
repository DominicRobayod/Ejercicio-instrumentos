classDiagram
    class Musical <<abstract>> {
        +tocar(): void
        +afinar(): void
        +add(m: Musical): void
        +remove(m: Musical): void
        +getChildren(): List~Musical~
        +getNombre(): String
    }

    class Instrumento {
        -nombre: String
        +Instrumento(nombre: String)
        +tocar(): void
        +afinar(): void
        +getNombre(): String
    }

    class GrupoMusical {
        -nombre: String
        -hijos: List~Musical~
        +GrupoMusical(nombre: String)
        +tocar(): void
        +afinar(): void
        +add(m: Musical): void
        +remove(m: Musical): void
        +getChildren(): List~Musical~
        +getNombre(): String
    }

    class Percusion {
        +Percusion()
        %% el constructor crea instrumentos: Batería, Congas, Bongós
    }
    class Cuerdas {
        +Cuerdas()
        %% el constructor crea instrumentos: Guitarra, Violín, Arpa
    }
    class Vientos {
        +Vientos()
        %% el constructor crea instrumentos: Flauta, Saxofón, Trompeta
    }

    %% Herencias
    Musical <|-- Instrumento
    Musical <|-- GrupoMusical
    GrupoMusical <|-- Percusion
    GrupoMusical <|-- Cuerdas
    GrupoMusical <|-- Vientos

    %% Agregación: GrupoMusical agrega Musical (0..* hijos)
    GrupoMusical o-- "0..*" Musical : contiene

    %% Relaciones entre Percusion, Cuerdas y Vientos (asociaciones entre sí)
    Percusion -- Cuerdas : relacionada
    Percusion -- Vientos : relacionada
    Cuerdas -- Vientos : relacionada

# Patrón Composite aplicado a un sistema musical

## Prompt original
Genera un diagrama de clases UML en formato mermaid para el patrón Composite aplicado a un sistema musical.

Detalles del diseño:

- Clase abstracta **Musical** con métodos:
  - `tocar(): void`
  - `afinar(): void`
  - `add(m: Musical)`
  - `remove(m: Musical)`
  - `getChildren(): List`
  - `getNombre(): String`

- Clase concreta **Instrumento** (hoja) que hereda de Musical.  
  - Atributo: `nombre: String`  
  - Implementa `tocar()`, `afinar()` y `getNombre()`

- Clase **GrupoMusical** (composite) que también hereda de Musical.  
  - Atributos: `nombre: String`, `hijos: List`  
  - Métodos: `tocar()`, `afinar()`, `add()`, `remove()`, `getChildren()`, `getNombre()`

- Clases concretas que heredan de GrupoMusical:
  - **Percusion** (constructor crea instrumentos de percusión como Batería, Congas, Bongós)
  - **Cuerdas** (constructor crea instrumentos de cuerdas como Guitarra, Violín, Arpa)
  - **Vientos** (constructor crea instrumentos de viento como Flauta, Saxofón, Trompeta)

Relaciones:  
- Musical es superclase abstracta de Instrumento y GrupoMusical.  
- GrupoMusical es padre de Percusion, Cuerdas y Vientos.  
- Percusion, Cuerdas y Vientos están relacionadas entre sí.  
- GrupoMusical tiene una relación de agregación con Musical.  
- Instrumento hereda de Musical.  
- Percusion, Cuerdas y Vientos heredan de GrupoMusical.  

---

## Diagrama en Mermaid

```mermaid
classDiagram
    %% Componente (arriba)
    class Musical {
        +tocar(): void
        +afinar(): void
        +add(m: Musical)
        +remove(m: Musical)
        +getChildren(): List
        +getNombre(): String
    }

    %% Hoja (izquierda)
    class Instrumento {
        +tocar(): void
        +afinar(): void
        +getNombre(): String
    }

    %% Composite (derecha)
    class GrupoMusical {
        +tocar(): void
        +afinar(): void
        +add(m: Musical)
        +remove(m: Musical)
        +getChildren(): List
        +getNombre(): String
    }

    %% Herencia
    Musical <|-- Instrumento
    Musical <|-- GrupoMusical

    %% Agregación: GrupoMusical contiene 0..* Musical
    GrupoMusical o-- "0..*" Musical : child
    GrupoMusical o-- "1" Musical : parent

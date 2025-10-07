# Patrón Composite aplicado a un sistema musical
## INTEGRANTES:
### Dominic Felipe Robayo Devia 20241020072
### Julian Esteban Valencia Vargas 20241020048

## Prompt original
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

---

## Diagrama en Mermaid

```mermaid
classDiagram
    class Musical {
        <<abstract>>
        + afinar()
        + tocar()
        + add()
        + remove()
    }

    class Instrumento {
        + afinar()
        + tocar()
    }

    class GrupoMusical {
        + afinar()
        + tocar()
        + add()
        + remove()
    }

    Musical <|-- Instrumento
    Musical <|-- GrupoMusical
    GrupoMusical "1" *-- "0..*" Musical : contiene

    %% ÚNICA agregación (como en la imagen)
    GrupoMusical o-- "0..*" Musical : children

# Patrón Composite aplicado a un sistema musical
## INTEGRANTES:
### Dominic Felipe Robayo Devia 20241020072
### Julian Esteban Valencia Vargas 20241020048

## Prompt original
Utiliza como referencia la siguiente imagen:
<img width="850" height="618" alt="image" src="https://github.com/user-attachments/assets/e0954cc4-1417-4018-a53b-3f7b119653db" />
<br>
y genera un diagrama de clases UML en formato mermaid para el patrón Composite aplicado a un sistema musical.

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

    %% ÚNICA agregación (como en la imagen)
    GrupoMusical o-- "0..*" Musical : children

Genera un diagrama de clases UML en formato mermaid para el patrón Composite aplicado a un sistema musical. 

Detalles del diseño:

1. Clase abstracta `Musical` con métodos:
   - tocar(): void
   - afinar(): void
   - add(m: Musical)
   - remove(m: Musical)
   - getChildren(): List
   - getNombre(): String

2. Clase concreta `Instrumento` (hoja) que hereda de `Musical`. 
   - Atributo: nombre: String
   - Implementa tocar(), afinar() y getNombre()

3. Clase `GrupoMusical` (composite) que también hereda de `Musical`.
   - Atributos: nombre: String, hijos: List<Musical>
   - Métodos: tocar(), afinar(), add(), remove(), getChildren(), getNombre()

4. Clases concretas que heredan de `GrupoMusical`:
   - `Percusion` (constructor crea instrumentos de percusión como Batería, Congas, Bongós)
   - `Cuerdas` (constructor crea instrumentos de cuerdas como Guitarra, Violín, Arpa)
   - `Vientos` (constructor crea instrumentos de viento como Flauta, Saxofón, Trompeta)

5. Relaciona `Musical` como la superclase abstracta de `Instrumento` y `GrupoMusical`, y luego `GrupoMusical` como padre de `Percusion`, `Cuerdas` y `Vientos`.

El diagrama debe mostrar herencia y la relación de composición entre GrupoMusical e Instrumento.
```mermaid
classDiagram
    class Musical {
        <<abstract>>
        + tocar(): void
        + afinar(): void
        + add(m: Musical)
        + remove(m: Musical)
        + getChildren(): List
        + getNombre(): String
    }

    class Instrumento {
        - nombre: String
        + tocar(): void
        + afinar(): void
        + getNombre(): String
    }

    class GrupoMusical {
        - nombre: String
        - hijos: List<Musical>
        + tocar(): void
        + afinar(): void
        + add(m: Musical)
        + remove(m: Musical)
        + getChildren(): List
        + getNombre(): String
    }

    class Percusion
    class Cuerdas
    class Vientos

    Musical <|-- Instrumento
    Musical <|-- GrupoMusical
    GrupoMusical <|-- Percusion
    GrupoMusical <|-- Cuerdas
    GrupoMusical <|-- Vientos

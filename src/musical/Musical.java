package musical;

import java.util.List;

/**
 * Clase abstracta Musical
 * Define la estructura del patrón Composite.
 */
public abstract class Musical {
    public abstract void tocar();
    public abstract void afinar();

    public void add(Musical m) {
        throw new UnsupportedOperationException("No soportado en instrumento simple.");
    }

    public void remove(Musical m) {
        throw new UnsupportedOperationException("No soportado en instrumento simple.");
    }

    public List<Musical> getChildren() {
        throw new UnsupportedOperationException("No soportado en instrumento simple.");
    }

    public String getNombre() {
        throw new UnsupportedOperationException("No soportado en instrumento simple.");
    }
}

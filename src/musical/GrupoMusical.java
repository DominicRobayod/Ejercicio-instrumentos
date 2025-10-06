package musical;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase compuesta: GrupoMusical
 * Contiene múltiples objetos Musical (instrumentos o subgrupos).
 */
public class GrupoMusical extends Musical {
    private String nombre;
    private List<Musical> instrumentos = new ArrayList<>();

    public GrupoMusical(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void tocar() {
        System.out.println("\n==============================");
        System.out.println("El grupo " + nombre + " comienza a tocar");
        System.out.println("==============================");
        for (Musical m : instrumentos) {
            m.tocar();
        }
    }

    @Override
    public void afinar() {
        System.out.println("\n******************************");
        System.out.println("El grupo " + nombre + " está afinando");
        System.out.println("******************************");
        for (Musical m : instrumentos) {
            m.afinar();
        }
    }

    @Override
    public void add(Musical m) {
        instrumentos.add(m);
    }

    @Override
    public void remove(Musical m) {
        instrumentos.remove(m);
    }

    @Override
    public List<Musical> getChildren() {
        return instrumentos;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}

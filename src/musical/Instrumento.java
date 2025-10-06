package musical;

/**
 * Clase hoja: Instrumento
 * Representa un instrumento simple.
 */
public class Instrumento extends Musical {
    private String nombre;

    public Instrumento(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void tocar() {
        System.out.println(nombre + " está tocando.");
    }

    @Override
    public void afinar() {
        System.out.println(nombre + " se está afinando.");
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}

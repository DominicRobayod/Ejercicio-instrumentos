package musical;

/**
 * Grupo Vientos: define sus instrumentos
 */
public class Vientos extends GrupoMusical {
    public Vientos() {
        super("Vientos");
        add(new Instrumento("Flauta"));
        add(new Instrumento("Trompeta"));
        add(new Instrumento("Saxofón"));
    }
}

package musical;

/**
 * Grupo Cuerdas: define sus instrumentos
 */
public class Cuerdas extends GrupoMusical {
    public Cuerdas() {
        super("Cuerdas");
        add(new Instrumento("Guitarra"));
        add(new Instrumento("Violín"));
        add(new Instrumento("Arpa"));
    }
}

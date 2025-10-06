package musical;

/**
 * Grupo Percusión: define sus instrumentos
 */
public class Percusion extends GrupoMusical {
    public Percusion() {
        super("Percusión");
        add(new Instrumento("Batería"));
        add(new Instrumento("Congas"));
        add(new Instrumento("Bongós"));
    }
}

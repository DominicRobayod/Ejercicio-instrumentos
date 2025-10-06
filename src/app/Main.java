package app;

import musical.*;
import java.util.Scanner;

/**
 * Clase principal con menú en consola.
 */
public class Main {

    private static GrupoMusical buscarGrupo(GrupoMusical grupo, String nombre) {
        if (grupo.getNombre().equalsIgnoreCase(nombre)) {
            return grupo;
        }
        for (Musical m : grupo.getChildren()) {
            if (m instanceof GrupoMusical) {
                GrupoMusical encontrado = buscarGrupo((GrupoMusical) m, nombre);
                if (encontrado != null) {
                    return encontrado;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Inicializar orquesta con grupos concretos
        GrupoMusical orquesta = new GrupoMusical("Orquesta");
        orquesta.add(new Percusion());
        orquesta.add(new Cuerdas());
        orquesta.add(new Vientos());

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Afinar orquesta completa");
            System.out.println("2. Tocar orquesta completa");
            System.out.println("3. Agregar nuevo grupo");
            System.out.println("4. Agregar instrumento a un grupo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> orquesta.afinar();
                case 2 -> orquesta.tocar();
                case 3 -> {
                    System.out.print("Ingrese el nombre del grupo padre: ");
                    String padre = sc.nextLine();
                    GrupoMusical grupoPadre = buscarGrupo(orquesta, padre);
                    if (grupoPadre != null) {
                        System.out.print("Ingrese el nombre del nuevo grupo: ");
                        String nombreGrupo = sc.nextLine();
                        grupoPadre.add(new GrupoMusical(nombreGrupo));
                        System.out.println("Grupo " + nombreGrupo + " agregado dentro de " + padre + ".");
                    } else {
                        System.out.println("No se encontró el grupo " + padre + ".");
                    }
                }
                case 4 -> {
                    System.out.print("Ingrese el nombre del grupo al que quiere agregar el instrumento: ");
                    String padre = sc.nextLine();
                    GrupoMusical grupoPadre = buscarGrupo(orquesta, padre);
                    if (grupoPadre != null) {
                        System.out.print("Ingrese el nombre del instrumento: ");
                        String nombreInstrumento = sc.nextLine();
                        grupoPadre.add(new Instrumento(nombreInstrumento));
                        System.out.println("Instrumento " + nombreInstrumento + " agregado al grupo " + padre + ".");
                    } else {
                        System.out.println("No se encontró el grupo " + padre + ".");
                    }
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}

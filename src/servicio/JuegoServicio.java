package servicio;

import modelo.PalabraSecreta;
import modelo.Jugador;
import util.Dibujador;

import java.util.*;

public class JuegoServicio {
    private static final int MAX_ERRORES = 6;
    private static final PalabraSecreta[] PALABRAS = {
        new PalabraSecreta("PROGRAMACION", " Escribes código para resolver problemas."),
        new PalabraSecreta("JAVA", " Lenguaje de programación popular con clases."),
        new PalabraSecreta("DINOSAURIO", " Animal prehistórico gigantesco."),
        new PalabraSecreta("CASTILLO", " Fortaleza antigua con torres."),
        new PalabraSecreta("MAGIA", " Arte de hechicería o ilusionismo."),
        new PalabraSecreta("ESPADA", " Arma medieval de filo largo.")
    };

    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();

    public void iniciarJuego(Jugador jugador) {
        do jugarRonda(jugador);
        while (preguntarRepetir());
        mostrarResumen(jugador);
    }

    private void jugarRonda(Jugador jugador) {
        PalabraSecreta Pista = PALABRAS[random.nextInt(PALABRAS.length)];
        String palabra = Pista.getTexto();
        char[] progreso = "_".repeat(palabra.length()).toCharArray();
        Set<Character> usadas = new HashSet<>();
        int errores = 0;

        System.out.println("\n=== NUEVA PARTIDA DEL AHORCADO ===\n" + Pista.getPista());

        while (errores < MAX_ERRORES && new String(progreso).contains("_")) {
            Dibujador.mostrarEstado(progreso, usadas, errores);
            char letra = leerLetra();

            if (!usadas.add(letra)) {
                System.out.println("Ya ingresaste esa letra.");
                continue;
            }

            if (actualizarProgreso(palabra, progreso, letra)) {
                System.out.println("¡Letra correcta!");
            } else {
                System.out.println("Letra incorrecta.");
                errores++;
            }
        }

        if (new String(progreso).equals(palabra)) {
            System.out.println("\n¡Ganaste! La palabra era: " + palabra);
            jugador.incrementarGanadas();
        } else {
            Dibujador.dibujarAhorcado(errores);
            System.out.println("\nPerdiste. La palabra era: " + palabra);
            jugador.incrementarPerdidas();
        }
    }

    private boolean actualizarProgreso(String palabra, char[] progreso, char letra) {
        boolean acierto = false;
        for (int i = 0; i < palabra.length(); i++)
            if (palabra.charAt(i) == letra) {
                progreso[i] = letra;
                acierto = true;
            }
        return acierto;
    }

    private char leerLetra() {
        while (true) {
            System.out.print("Ingresa una letra: ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.length() == 1 && Character.isLetter(input.charAt(0)))
                return input.charAt(0);
            System.out.println(" Entrada inválida. Escribe una letra.");
        }
    }

    private boolean preguntarRepetir() {
        while (true) {
            System.out.print("\n¿Quieres jugar otra vez? (s/n): ");
            String Repetir = scanner.nextLine().trim().toLowerCase();
            if (Repetir.equals("s")) return true;
            if (Repetir.equals("n")) return false;
            System.out.println(" Opción inválida. Escribe 's' o 'n'.");
        }
    }

    private void mostrarResumen(Jugador Jugadas) {
        System.out.println("\nResumen de partidas:\nGanadas: " + Jugadas.getPartidasGanadas() +
                           "\nPerdidas: " + Jugadas.getPartidasPerdidas() + "\nGracias por jugar.");
    }
}

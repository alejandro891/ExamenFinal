package servicio;

import modelo.PalabraSecreta;
import modelo.Jugador;
import util.Dibujador;

import java.util.*;

public class JuegoServicio {
    private static final int MAX_ERRORES = 6;
    private static final PalabraSecreta[] PALABRAS = {
        new PalabraSecreta("PROGRAMACION", "💡 Escribes código para resolver problemas."),
        new PalabraSecreta("JAVA", "💡 Lenguaje de programación popular con clases."),
        new PalabraSecreta("DINOSAURIO", "💡 Animal prehistórico gigantesco."),
        new PalabraSecreta("CASTILLO", "💡 Fortaleza antigua con torres."),
        new PalabraSecreta("MAGIA", "💡 Arte de hechicería o ilusionismo."),
        new PalabraSecreta("ESPADA", "💡 Arma medieval de filo largo.")
    };

    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);

    public void iniciarJuego(Jugador jugador) {
        boolean seguirJugando;
        do {
            jugarRonda(jugador);
            seguirJugando = preguntarRepetir();
        } while (seguirJugando);
        mostrarResumen(jugador);
    }

    private PalabraSecreta seleccionarPalabra() {
        return PALABRAS[random.nextInt(PALABRAS.length)];
    }

    private void jugarRonda(Jugador jugador) {
        PalabraSecreta palabraSecreta = seleccionarPalabra();
        String palabra = palabraSecreta.getTexto();
        String pista = palabraSecreta.getPista();

        char[] progreso = new char[palabra.length()];
        Arrays.fill(progreso, '_');
        Set<Character> letrasUsadas = new HashSet<>();
        int errores = 0;

        System.out.println("\n=== NUEVA PARTIDA DEL AHORCADO ===");
        System.out.println(pista);

        while (errores < MAX_ERRORES && new String(progreso).contains("_")) {
            Dibujador.mostrarEstado(progreso, letrasUsadas, errores);
            char letra = leerLetra();

            if (letrasUsadas.contains(letra)) {
                System.out.println("Ya ingresaste esa letra.");
                continue;
            }

            letrasUsadas.add(letra);
            boolean acierto = actualizarProgreso(palabra, progreso, letra);

            if (acierto) {
                System.out.println("¡Letra correcta!");
            } else {
                errores++;
                System.out.println("Letra incorrecta.");
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
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                progreso[i] = letra;
                acierto = true;
            }
        }
        return acierto;
    }

    private char leerLetra() {
        while (true) {
            try {
                System.out.print("Ingresa una letra: ");
                String input = scanner.nextLine().toUpperCase();

                if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                    throw new InputMismatchException("Entrada inválida. Escribe una sola letra.");
                }

                return input.charAt(0);
            } catch (InputMismatchException e) {
                System.out.println(" " + e.getMessage());
            }
        }
    }

    private boolean preguntarRepetir() {
        while (true) {
            System.out.print("\n¿Quieres jugar otra vez? (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            if (respuesta.equals("s")) return true;
            if (respuesta.equals("n")) return false;
            System.out.println("⚠ Opción inválida. Escribe 's' o 'n'.");
        }
    }

    private void mostrarResumen(Jugador jugador) {
        System.out.println("\nResumen de partidas:");
        System.out.println("Ganadas: " + jugador.getPartidasGanadas());
        System.out.println("Perdidas: " + jugador.getPartidasPerdidas());
        System.out.println("Gracias por jugar.");
    }
}

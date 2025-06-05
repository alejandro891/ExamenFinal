package util;

import java.util.Set;

public class Dibujador {
    public static void dibujarAhorcado(int errores) {
        System.out.println("\n +---+");
        System.out.println(" |   |");
        System.out.println(" " + (errores > 0 ? "O" : " ") + "   |");
        System.out.print((errores > 2 ? "/" : " ") + (errores > 1 ? "|" : " ") + (errores > 3 ? "\\" : " "));
        System.out.println("  |");
        System.out.print((errores > 4 ? "/" : " ") + " " + (errores > 5 ? "\\" : " "));
        System.out.println("  |");
        System.out.println("     |");
        System.out.println("=========");
    }

    public static void mostrarEstado(char[] progreso, Set<Character> letrasUsadas, int errores) {
        dibujarAhorcado(errores);
        System.out.println("Palabra: " + String.valueOf(progreso));
        System.out.println("Letras usadas: " + letrasUsadas);
    }
}

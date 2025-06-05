package modelo;

public class Persona {
    private int partidasGanadas;
    private int partidasPerdidas;

    public void incrementarGanadas() {
        partidasGanadas++;
    }

    public void incrementarPerdidas() {
        partidasPerdidas++;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }
}

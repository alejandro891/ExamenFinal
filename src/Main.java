import modelo.Jugador;
import servicio.JuegoServicio;

public class Main {
    public static void main(String[] args) {
        Jugador jugador = new Jugador();
        JuegoServicio juego = new JuegoServicio();
        juego.iniciarJuego(jugador);
    }
}

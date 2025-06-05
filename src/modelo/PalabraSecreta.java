package modelo;

public class PalabraSecreta {
    private final String texto;
    private final String pista;

    public PalabraSecreta(String texto, String pista) {
        this.texto = texto.toUpperCase();
        this.pista = pista;
    }

    public String getTexto() {
        return texto;
    }

    public String getPista() {
        return pista;
    }
}

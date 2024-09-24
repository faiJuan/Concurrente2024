package TP3.punto7;

public class Controlador {
    private char letra;

    public Controlador(char unaL) {
        this.letra = unaL;
    }

    public synchronized char obtenerTurno() {
        return letra;
    }

    public synchronized void cambiarTurno(char unaLetra) {
        switch (unaLetra) {
            case 'A':
                letra = 'B';
                break;
            case 'B':
                letra = 'C';
                break;
            case 'C':
                letra = 'A';
                break;
        }
    }
}

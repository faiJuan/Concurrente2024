package TP3.punto7;

public class Letra implements Runnable {
    private char letra;
    private int cantidad;
    private Controlador controlador;

    public Letra(char unaLetra, int unaCant, Controlador unControlador) {
        this.letra = unaLetra;
        this.cantidad = unaCant;
        controlador = unControlador;
    }

    public void run() {
        try {
            while (true) {
                if (controlador.obtenerTurno() == letra) {
                    //es necesasrio que el obtener turno sea synchronized?
                    for (int i = 0; i < cantidad; i++) {
                        System.out.print(letra);
                    }
                    controlador.cambiarTurno(letra);
                }
            }
        } catch (Exception e) {

        }
    }

}

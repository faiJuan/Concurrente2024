package TP3.punto3;

import java.util.Random;

public class Hamster implements Runnable {
    private Rueda rueda;
    private Hamaca hamaca;
    private Plato plato;

    public Hamster(Plato unP, Hamaca unH, Rueda unaR) {
        this.plato = unP;
        this.hamaca = unH;
        this.rueda = unaR;
    }

    public void run() {
        while (true) {
            Random ran = new Random();
            int numero = ran.nextInt(3) + 1;
            try {
                switch (numero) {
                    case 1:
                        plato.usarPlato();
                        break;
                    case 2:
                        rueda.usarRueda();
                        break;
                    case 3:
                        hamaca.usarHamaca();
                        break;
                }
            } catch (Exception e) {

            }
        }
    }
}

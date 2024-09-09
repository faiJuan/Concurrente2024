package TP3.punto3;

import java.util.Random;

public class Hamster implements Runnable {
    Rueda rueda;
    Plato plato;
    Hamaca hamaca;

    public Hamster(Plato p, Rueda r, Hamaca h) {
        this.plato = p;
        this.rueda = r;
        this.hamaca = h;
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
                        rueda.usaRueda();
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
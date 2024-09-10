package TP3.punto6;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int suma[] = new int[100];
        Thread[] sumadores = new Thread[4];
        Suma recurso = new Suma();
        int division = 24;

        for (int i = 0; i < 100; i++) {
            suma[i] = new Random().nextInt(10) + 1;

        }

        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                sumadores[i] = new Thread(new Sumador(0, division, suma, recurso));
                sumadores[i].start();
            } else if (i == 3) {
                sumadores[i] = new Thread(new Sumador((division * i + 1), suma.length - 1, suma, recurso));
                sumadores[i].start();
            } else {
                sumadores[i] = new Thread(new Sumador((division * i + 1), division * (i + 1), suma, recurso));
                sumadores[i].start();
            }
        }

        for (int i = 0; i < sumadores.length; i++) {
            try {
                sumadores[i].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("El total es: " + recurso.obtenerTotal());

    }

}

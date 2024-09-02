package TP2.punto6;

public class Main {
    public static void main(String[] args) {
        Thread[] corredores = new Thread[5];
        Corredor[] a = new Corredor[5];
        int longi = corredores.length;
        int ganador = 0;
        for (int i = 0; i < longi - 1; i++) {
            a[i] = new Corredor(i);
        }
        for (int i = 0; i < longi - 1; i++) {
            corredores[i] = new Thread(a[i]);
            corredores[i].start();
        }
        for (int i = 0; i < longi - 1; i++) {
            try {
                corredores[i].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        for (int i = 0; i < longi - 1; i++) {
            if (i == 0) {
                ganador = a[i].distanciaTotal();
            } else {
                if (ganador < a[i].distanciaTotal()) {
                    ganador = a[i].distanciaTotal();
                }
            }

        }
        System.out.println("ganador");

    }
}

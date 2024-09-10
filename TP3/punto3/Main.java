package TP3.punto3;

public class Main {
    public static void main(String[] args) {
        Rueda rueda= new Rueda();
        Hamaca hamaca= new Hamaca();
        Plato plato= new Plato();
        Thread [] hamsters= new Thread[15];

        for (int i = 0; i <15; i++) {
            hamsters[i]= new Thread (new Hamster(plato, hamaca, rueda));
            hamsters[i].start();
        }

    }
}

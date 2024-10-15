package TP5.punto8;

public class Main {
    public static void main(String[] args) {
        Soga soga= new Soga();
        Thread [] ladoA=new Thread [13];
        Thread [] ladoB=new Thread [7];
        Thread controlador=new Thread(new Controlador(soga));

        for (int i = 0; i < ladoA.length; i++) {
            ladoA[i]=new Thread(new Babuino(soga,'A'));
            ladoA[i].start();
        }

        for (int i = 0; i < ladoB.length; i++) {
            ladoB[i]=new Thread(new Babuino(soga,'B'));
            ladoB[i].start();
        }

        controlador.start();

        }
    }


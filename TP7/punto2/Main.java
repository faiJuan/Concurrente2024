package TP7.punto2;

public class Main {
    public static void main(String[] args) {
        Thread[] programadores=new Thread [20];
        Coordinador oficina=new Coordinador(5, 5);

        for (int i = 0; i < programadores.length; i++) {
            programadores[i]=new Thread(new Programador(i, oficina));
            programadores[i].start();
        }
    }
}

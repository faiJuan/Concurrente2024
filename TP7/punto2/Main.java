package TP7.punto2;

public class Main {
    public static void main(String[] args) {
        Thread[] programadores=new Thread [8];
        Coordinador oficina=new Coordinador(2, 1);

        for (int i = 0; i < programadores.length; i++) {
            programadores[i]=new Thread(new Programador(i, oficina));
            programadores[i].start();
        }
    }
    
}

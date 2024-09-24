package TP3.punto7;

public class Main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador('A');
        Thread h1 = new Thread(new Letra('A', 1, controlador));
        h1.start();
        Thread h2 = new Thread(new Letra('B', 1, controlador));
        h2.start();
        Thread h3 = new Thread(new Letra('C', 1, controlador));
        h3.start();
    }
}

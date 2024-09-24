package TP4.punto7;

public class Main {
    public static void main(String[] args) {
        Silla silla= new Silla();
        Thread mozo=new Thread(new Mozo(silla));
        Thread [] clientes=new Thread[5];

        for (int i = 0; i < clientes.length; i++) {
            clientes[i]=new Thread (new Empleado(silla));
            clientes[i].start();
        }
        mozo.start();
    }
}

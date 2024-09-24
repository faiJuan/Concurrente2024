package TP4.punto6;

public class Main {
    public static void main(String[] args) {
        Recurso recurso= new Recurso();
        Thread n1= new Thread (new Taxista(recurso));
        n1.start();
        Thread n2=new Thread (new Pasajero(recurso));
        n2.start();;
    }
}

package TP3.punto3;

public class Rueda {
    public Rueda (){
    }

    

    public synchronized void usaRueda ()throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" esta corriendo");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+" termino de correr");
    }
}

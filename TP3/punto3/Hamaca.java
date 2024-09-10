package TP3.punto3;

public class Hamaca {
 
    public Hamaca (){
    }

    public synchronized void usarHamaca ()throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" esta descanzando");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+" termino de usar la hamaca");

    }
}

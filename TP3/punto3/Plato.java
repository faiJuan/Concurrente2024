package TP3.punto3;

public class Plato {
    public Plato (){
    }

    

    public synchronized void usarPlato ()throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" esta comiendo");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+" termino de comer");
    }
}
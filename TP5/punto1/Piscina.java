package TP5.punto1;
import java.util.concurrent.Semaphore;
public class Piscina {
    private int capacidad=0;
    private Semaphore cupos;
    public Piscina (int cant){
        this.capacidad=cant;
        this.cupos= new Semaphore (cant, true);
    }

    public void usarPiscina () throws InterruptedException{
        cupos.acquire();
        System.out.println(Thread.currentThread().getName()+" esta usando la piscina");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName()+" salio de la piscina");
        cupos.release();
    }

}

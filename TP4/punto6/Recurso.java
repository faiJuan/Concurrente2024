package TP4.punto6;
import java.util.concurrent.Semaphore;
public class Recurso {
    private Semaphore pasajero;
    private Semaphore taxista;

    public Recurso (){
        pasajero= new Semaphore(1);
        taxista= new Semaphore (0);
    }

    public void usarTaxi() throws InterruptedException{
        pasajero.acquire();
        System.out.println("buscando taxi");
        Thread.sleep(1000);
        System.out.println("despertando taxista y subiendo al taxi");
        taxista.release();
        pasajero.acquire();
        System.out.println("bajando del taxi");
        pasajero.release();
        

    }

    public void taxista () throws InterruptedException{
        taxista.acquire();
        System.out.println("taxista descansando");
        taxista.release();
        System.out.println("iniciando viaje");
        Thread.sleep(3000);
        System.out.println("viaje terminado");
        pasajero.release();


    }
}

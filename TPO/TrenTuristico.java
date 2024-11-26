package TPO;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

public class TrenTuristico {
    private BlockingQueue <String> aux3,aux,tren,aux2,aux4;
    private int cant;
    
    private long tiempoEspera;

    public TrenTuristico (){
        cant=10;
        tren=new ArrayBlockingQueue<>(cant);
        aux=new SynchronousQueue<>();
        aux2=new SynchronousQueue<>();
        aux4=new ArrayBlockingQueue<>(cant-1);
        aux3=new ArrayBlockingQueue<>(cant);
        tiempoEspera=5;
    }

    public void subirTren(String nombre) throws InterruptedException{
        tren.put(nombre);
        aux3.put(nombre);
        System.out.println("El visitante"+nombre+" subio al tren");
        if(!aux4.offer(nombre)){

            aux.put("Tren lleno");
        }
    }
    public void empezarViaje() throws InterruptedException{
        aux.take();
        System.out.println("Empezo el viaje");
        Thread.sleep(2000);
        System.out.println("Termino el viaje");
        aux2.put("termino viaje");
    }


    public void bajarTren() throws InterruptedException{
        aux2.take();
        System.out.println(Thread.currentThread().getName()+" se bajo del tren");
        aux3.take();
        if(aux3.remainingCapacity()>=10){
            aux4.clear();
            tren.clear();
        }else{aux2.put(" ");}


    }

}
/* 
public class TrenTuristico {
    private int cant;
    private Semaphore colaFila,colaTren,mutex,maquinista;
    
    public TrenTuristico (){
        cant=10;
        colaFila=new Semaphore(10);
        maquinista=new Semaphore(0);
        mutex=new Semaphore(1);
        colaTren=new Semaphore(0);
        
    }

    public void entrarTren() throws InterruptedException{
        colaFila.acquire();
        System.out.println("un pasajero entro al tren");
        mutex.acquire();
        cant--;
        if(cant==0){
            maquinista.release();
        }
        mutex.release();
    }

    public void empezarViaje() throws InterruptedException{
        maquinista.acquire();
        System.out.println("empezo el viaje");
        Thread.sleep(1000);
        System.out.println("Termino el viaje");
        colaTren.release(10);
    }

    public void salirTren() throws InterruptedException{
        colaTren.acquire();
        System.out.println("salio del tren");
        mutex.acquire();
        cant++;
        if(cant>=10){
            colaFila.release(10);
        }
        mutex.release();

    }


}*/

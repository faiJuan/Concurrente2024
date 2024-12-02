package TPO;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TrenTuristico {
    private BlockingQueue<String> tren, intercambio;
    private int cant, cantidadPersonas;
    private Semaphore mutex, mutex2;
    private boolean seguirJugando;

    public TrenTuristico() {
        cantidadPersonas = 0;
        cant = 10;
        tren = new ArrayBlockingQueue<>(cant);
        intercambio = new ArrayBlockingQueue<>(1);
        mutex = new Semaphore(1);
        mutex2 = new Semaphore(0);
        seguirJugando=true;
    }

    public void subirTren(String nombre) throws InterruptedException {
        tren.put(nombre);
        mutex.acquire();
        if(seguirJugando){
            System.out.println(Thread.currentThread().getName() + " se subio al tren");
        cantidadPersonas++;
        if (cantidadPersonas >= 10) {
            System.out.println("se lleno");
            System.out.println(cantidadPersonas);
            intercambio.put("puede salir");
        }
        }
        mutex.release();

    }

    public void empezarViaje() throws InterruptedException {
        intercambio.poll(10, TimeUnit.SECONDS);
        mutex.acquire();
        System.out.println("El tren turistico inicio su viaje");
    }

    public void terminarViaje() throws InterruptedException {
        System.out.println("El tren turistico termino su viaje");
        mutex2.release();
    }

    public void bajarTren() throws InterruptedException {
        mutex2.acquire();
        if(seguirJugando){
            System.out.println(Thread.currentThread().getName() + " se bajo del tren");
        cantidadPersonas--;
        tren.take();
        if (cantidadPersonas <= 0) {
            mutex.release();
        } else {
            mutex2.release();
        }
        }else{
            if (cantidadPersonas>0) {
                System.out.println(Thread.currentThread().getName() + " se bajo del tren");
                cantidadPersonas--;
            } else {
                mutex2.release();
            }
        }
        
    }

    public void terminarJuego() throws InterruptedException{
        tren.clear();
        seguirJugando=false;
        System.out.println("El tren turistico trmino su recorrido por hoy");
    }

}
/*
 * public class TrenTuristico {
 ** esta ejemplo quedo a modo de muestra para hacerlo solo con colas
 * private BlockingQueue <String> aux3,aux,tren,aux2,aux4;
 * private int cant;
 * 
 * private long tiempoEspera;
 * 
 * public TrenTuristico (){
 * cant=10;
 * tren=new ArrayBlockingQueue<>(cant);
 * aux=new SynchronousQueue<>();
 * aux2=new SynchronousQueue<>();
 * aux4=new ArrayBlockingQueue<>(cant-1);
 * aux3=new ArrayBlockingQueue<>(cant);
 * tiempoEspera=5;
 * }
 * 
 * public void subirTren(String nombre) throws InterruptedException{
 * tren.put(nombre);
 * aux3.put(nombre);
 * System.out.println("El visitante"+nombre+" subio al tren");
 * if(!aux4.offer(nombre)){
 * 
 * aux.put("Tren lleno");
 * }
 * }
 * public void empezarViaje() throws InterruptedException{
 * aux.take();
 * System.out.println("Empezo el viaje");
 * Thread.sleep(2000);
 * System.out.println("Termino el viaje");
 * aux2.put("termino viaje");
 * }
 * 
 * 
 * public void bajarTren() throws InterruptedException{
 * aux2.take();
 * System.out.println(Thread.currentThread().getName()+" se bajo del tren");
 * aux3.take();
 * if(aux3.remainingCapacity()>=10){
 * aux4.clear();
 * tren.clear();
 * }else{aux2.put(" ");}
 * 
 * 
 * }
 * 
 * }
 */

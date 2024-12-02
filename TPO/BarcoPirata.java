package TPO;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BarcoPirata {
    

    private int asientosOcupados,contador;
    private ReentrantLock lock;
    private Condition areaEspera,barco,encargadoBarco;
    private boolean empezo,seguirJuego;

    public BarcoPirata (){
        contador=0;
        asientosOcupados = 0;
        lock=new ReentrantLock();
        areaEspera=lock.newCondition();
        barco=lock.newCondition();
        encargadoBarco=lock.newCondition();
        empezo=false;
        seguirJuego=true;
    }

    public boolean subirBarco() throws InterruptedException{
        
        lock.lock();

        try {
            while(asientosOcupados>=20 && empezo){
                System.out.println("Esp");
                areaEspera.await();
                
            }
            if (seguirJuego) {
                System.out.println(Thread.currentThread().getName()+" se subio al barco");
            asientosOcupados++;
            contador++;
            if(asientosOcupados>=20){
                encargadoBarco.signal();
            }
            barco.await();
        }else{
            System.out.println(Thread.currentThread().getName()+" no pudo sibirse");
        }
        
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            
            lock.unlock();
        }
        return seguirJuego;
        
    }

    public void empezarJuegoBarco() {
        lock.lock();
        try {
            encargadoBarco.await(5,TimeUnit.SECONDS);
            empezo=true;
            System.out.println("inicio el juego del barco pirata");
            
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }

    public void terminarJuegoBarco() {
        lock.lock();
        try {
            System.out.println("Termino el juego del barco pirata");
            barco.signalAll();
            
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }

    public void bajarBarco(){
        lock.lock();
        try {
            if(seguirJuego){
                contador--;
            System.out.println(Thread.currentThread().getName()+" se bajo del barco");
            if(contador<=0){
                asientosOcupados=0;
                empezo=false;
                areaEspera.signalAll();
            }
            }else{
                if(contador>0){
                    contador--;
                    System.out.println(Thread.currentThread().getName()+" se bajo del barco");
                }else{
                    asientosOcupados=0;
                }
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }

    public void cerrarJuego(){
        lock.lock();
        try {
            seguirJuego=false;
            empezo=false;
            areaEspera.signalAll();
            System.out.println("El juego del barco pirata se cerro");
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }





    /*public boolean subirBarco() throws InterruptedException{
        
        lock.lock();
        boolean continuar=true;
        try {
            while(asientosOcupados>=20 && !empezo){
                areaEspera.await();
                continuar=continuarJugando();
            }
            System.out.println(Thread.currentThread().getName()+" se subio al barco");
            asientosOcupados++;
            contador++;
            if(asientosOcupados>=20){
                encargadoBarco.signal();
            }
            barco.await();
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }

    public void empezarJuegoBarco() {
        lock.lock();
        try {
            encargadoBarco.await(5,TimeUnit.SECONDS);
            empezo=true;
            System.out.println("inicio el juego del barco pirata");
            //Thread.sleep(3000); poner el sleep en el run
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }

    public void terminarJuegoBarco() {
        lock.lock();
        try {
            System.out.println("Termino el juego del barco pirata");
            barco.signalAll();
            
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }

    public void bajarBarco(){
        lock.lock();
        try {
            contador--;
            System.out.println(Thread.currentThread().getName()+" se bajo del barco");
            if(contador<=0){
                asientosOcupados=0;
                empezo=false;
                areaEspera.signalAll();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    } */


}

package TPO;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class ControlParque {

    private ReentrantLock lock;
    private Condition zonaEspera,encargado;
    private boolean abierto,empezarJuego;

    public ControlParque (){
        this.lock=new ReentrantLock();
        zonaEspera=lock.newCondition();
        encargado=lock.newCondition();
        abierto=false;
        empezarJuego=false;//esta variable le indica a los encargados de juegos que pueden comenzar sus atracciones.
    }

    public void abrirParque (){
        lock.lock();
        try {
            System.out.println("Abrio el parque");
            abierto=true;
            empezarJuego=true;
            zonaEspera.signalAll();
            
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }

    public void entrarParque ()throws InterruptedException{
        lock.lock();
        try {
            while(!abierto){
                zonaEspera.await();
            }
            System.out.println(Thread.currentThread().getName()+" entro al parque");
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
        
    }

    public void cerrarParque () throws InterruptedException{
        lock.lock();
        try {
            encargado.await(10,TimeUnit.SECONDS);
            System.out.println("Cerro el ingreso al parque");
            abierto=false;
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }

    }

    public void cierreAtracciones ()throws InterruptedException{
        lock.lock();
        try {
            encargado.await(1,TimeUnit.SECONDS);
            empezarJuego=false;
            System.out.println("Las atracciones ya no pueden comenzar, favor de retirarse los visitantes");
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }

    public boolean getPermisoComienzo()throws InterruptedException{
        return empezarJuego;
    }
}

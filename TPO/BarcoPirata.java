package TPO;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BarcoPirata {
    /* El barco pirata tiene capacidad para 20 personas. 
    El viaje comienza cuando todas las plazas están llenas, 
    o bien después de un determinado tiempo de espera. 
    Los visitantes que no logran ingresar deben esperar al próximo viaje. */

    private int asientosOcupados,contador;
    private ReentrantLock lock;
    private Condition areaEspera,barco,encargadoBarco;
    private boolean empezo;

    public BarcoPirata (){
        contador=0;
        asientosOcupados = 0;
        lock=new ReentrantLock();
        areaEspera=lock.newCondition();
        barco=lock.newCondition();
        encargadoBarco=lock.newCondition();
        empezo=false;
    }

    public void subirBarco() throws InterruptedException{
        lock.lock();
        try {
            while(asientosOcupados>=20 && !empezo){
                areaEspera.await();
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
    }

}

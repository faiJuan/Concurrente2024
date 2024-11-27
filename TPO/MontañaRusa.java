package TPO;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;



public class MontañaRusa{
    private int cantidad,espacioMax,quierenSubirse,listo;
    private ReentrantLock lock;
    private Condition espacioEspera, carro, encargado;

    public MontañaRusa(){
        espacioMax=20;
        cantidad=0;
        listo=0;
        lock=new ReentrantLock();
        espacioEspera=lock.newCondition();
        carro=lock.newCondition();
        encargado=lock.newCondition();
        quierenSubirse=0;
    }

    public void subirMontaña()throws InterruptedException{
        lock.lock();
        try {
            quierenSubirse++;
            if(quierenSubirse>espacioMax){
                System.out.println(Thread.currentThread().getName()+" no pudo subir a la montaña rusa, el espacio de espera estaba lleno");
                
            }else{
                
                while(cantidad>=5){
                    espacioEspera.await();
                }
                cantidad++;
                listo++;
                quierenSubirse--;
                System.out.println(Thread.currentThread().getName()+" se subio a la montaña rusa");
                if(cantidad>=5){
                    encargado.signal();
                }
                carro.await();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }

    public void arrancarJuego()throws InterruptedException{
        lock.lock();
        try {
            encargado.await();
            System.out.println("inicio el juego de montaña rusa");
            Thread.sleep(3000);
            System.out.println("Termino el juego de la montaña rusa");
            carro.signalAll();
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }

    public void bajarseMontañaRusa(){
        lock.lock();
        try {
            listo--;
            System.out.println(Thread.currentThread().getName()+" se bajo de la montaña rusa");
            if(listo<=0){
                cantidad=0;
                espacioEspera.signalAll();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }
}





package TPO;

import java.util.concurrent.Semaphore;

public class AutoChocador {
    private Semaphore mutex,personasMax,encargadoAutos,mutex2;
    private Semaphore[] autos;
    private int contadorPersonas,autoActual,personasEnAuto;

    public AutoChocador(){
        this.contadorPersonas = 0;
        this.autoActual=0;
        this.personasEnAuto=0;
        this.personasMax=new Semaphore(20);
        this.autos=new Semaphore[10];
        this.mutex=new Semaphore(1);
        this.mutex2 = new Semaphore(1);
        this.encargadoAutos=new Semaphore(0);
        for (int i = 0; i < autos.length; i++) {
            autos[i]=new Semaphore(0);
        }
    }

    public void entrarJuegoAuto()throws InterruptedException{
            personasMax.acquire();
            mutex.acquire();
            contadorPersonas++;
            System.out.println(Thread.currentThread().getName()+" se subio al auto "+(autoActual+1));
            if(contadorPersonas>=20){
                encargadoAutos.release();
                subirAuto(autoActual);
            }else{
                if(personasEnAuto>=1){
                    autoActual++;
                    personasEnAuto=0;
                    System.out.println("segundo que se subio");
                    subirAuto(autoActual-1);
                    
                }else{
                    personasEnAuto++;
                    System.out.println("primero que se subio");
                    subirAuto(autoActual);
                }
            } 
        
    }

    private void subirAuto(int suAuto) throws InterruptedException{
        mutex.release();
        autos[suAuto].acquire();
    }

    public void empezarJuego() throws InterruptedException{
        encargadoAutos.acquire();
        System.out.println("El juego de los autos chocadores comenzo");
        
    }
    public void terminarJuego() throws InterruptedException{
        System.out.println("Termino el juego de los autos chocadores");
        for (int i = 0; i < autos.length; i++) {
            autos[i].release(2);
        }
    }

    public void bajarAuto() throws InterruptedException{
        mutex2.acquire();
        System.out.println(Thread.currentThread().getName()+ " se bajo del auto");
        contadorPersonas--;
        if(contadorPersonas<=0){
            autoActual=0;
            personasEnAuto=0;
            personasMax.release(20);
        }
        mutex2.release();
    }
}

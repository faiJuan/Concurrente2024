package TP3.punto3;

public class Hamaca {
    private boolean ocupado;
    public Hamaca (){
        this.ocupado=false;
    }

    public void usarHamaca ()throws InterruptedException{
        if(!ocupado){
            ocupado=true;
            this.descansar();
            ocupado=false;
        }
    }

    public synchronized void descansar ()throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" esta corriendo");
        Thread.sleep(1000);
    }
}

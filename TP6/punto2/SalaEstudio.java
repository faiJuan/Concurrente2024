package TP6.punto2;

public class SalaEstudio {
    private int mesasUsadas,total,turno,turnoActual;
    
    public SalaEstudio (int t){
        this.mesasUsadas=0;
        this.total=t;
        this.turno=0;
        this.turnoActual=0;
    }

    public synchronized int obtenerTurno (){
        turno++;

        return turno;
    }

    public synchronized void usarMesa() throws InterruptedException{
            while(mesasUsadas>=total){
                wait();
            }
            mesasUsadas++;
            System.out.println(Thread.currentThread().getName()+" esta usando una mesa");
        
        
    }

    public synchronized void dejarMesa (){
        mesasUsadas--;
        System.out.println(Thread.currentThread().getName()+" dejo de usar mesa. Se fue de la biblioteca");
        notifyAll();
    }
}
